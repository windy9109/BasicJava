package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class NoticeBoardDao {
	private NoticeBoardDao() {}
	private static NoticeBoardDao instance;
	public static NoticeBoardDao getInstnace() {
		if(instance == null) {
			instance= new NoticeBoardDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public static List<Map<String, Object>> notice = new ArrayList<>();
	
	
	public List<Map<String, Object>> noticeList(){
		String sql = "SELECT NOTICE_NO," + 
				"            SUBSTR(NOTICE_TITLE,1,5)||'...' AS NOTICE_TITLE," + 
				"            NOTICE_DATE" + 
				"       FROM NOTICE"
				+ "    ORDER BY 1 ";
		
		notice = jdbc.selectList(sql);
		
		
		return notice;
	}
	
	public Map<String, Object> noticeView(List<Object> param){
		
		String sql = "SELECT NOTICE_NO"
				+ " 	, 	 NOTICE_TITLE"
				+ " 	,    NOTICE_DATE"
				+ " 	,    NOTICE_CONTENT"
				+ " 	FROM NOTICE"
				+ " 	WHERE NOTICE_NO = ?";
		Map<String, Object> map = jdbc.selectOne(sql, param);
		
		return map;
		
	}
	
	public List<Map<String, Object>> boardList(){
		String sql = "SELECT BOARD_NO," + 
				"       SUBSTR(BOARD_TITLE,1,5)||'...' AS BOARD_TITLE," + 
				"       MEM_ID," + 
				"       BOARD_DATE" + 
				"  FROM BOARD"
				+ " ORDER BY 1 ";
	
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> boardView(List<Object> param){
		
		String sql = "SELECT BOARD_NO," + 
				"       BOARD_TITLE," + 
				"       BOARD_DATE," + 
				"       MEM_ID," + 
				"       BOARD_CONTENT" + 
				"  FROM BOARD" + 
				" WHERE BOARD_NO = ?";

		return jdbc.selectOne(sql, param);
		
	}
	
	public int boardInsert(List<Object> param){
		
		String sql = "INSERT INTO BOARD VALUES ((SELECT NVL(MAX(BOARD_NO), 0)+1 FROM BOARD)," + 
				"                           ?," + 
				"                           ?," + 
				"                           SYSDATE," + 
				"                           ?)";

		return jdbc.update(sql, param);
		
	}
	
	public int boardDelete(List<Object> param) {
		String sql = "DELETE FROM BOARD" + 
				"      WHERE BOARD_NO = ?"
				+ "		 AND MEM_ID = ?";
		
		return jdbc.update(sql, param);
	}
	
	public int boardUpdate(List<Object> param) {
		String sql = "UPDATE BOARD" + 
				"     	 SET BOARD_TITLE = ?," + 
				"            BOARD_CONTENT = ? ,"+ 
				"            BOARD_DATE = SYSDATE" + 
				"      WHERE BOARD_NO = ?"
				+ "		 AND MEM_ID = ?";
		
		return jdbc.update(sql,param);
	}
	
	
}
