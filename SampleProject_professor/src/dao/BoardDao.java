package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {

	private BoardDao() {
		
	}
	private static BoardDao instance;
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO"
				+ "		   , A.TITLE"
				+ "		   , B.MEM_NAME"
				+ "		   , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "	   ORDER BY A.BOARD_NO DESC";
		
		return JDBCUtil.selectList(sql);
	}


	public Map<String, Object> selectBoard(int boardNo) {
		String sql = "SELECT A.BOARD_NO"
				+ "		   , A.TITLE"
				+ "		   , A.CONTENT"
				+ "		   , B.MEM_NAME"
				+ "		   , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "	   WHERE A.BOARD_NO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		
		return JDBCUtil.selectOne(sql, param);
	}


	public int insertBoard(String title, String content, String memId) {
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "	VALUES ("
				+ "		(SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
				+ "		, ?, ?, ?"
				+ "		, SYSDATE"
				+ "	)";
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(memId);
		
		return JDBCUtil.update(sql, param);
	}


	public int updateBoard(int boardNo, String title, String content) {
		String sql = "UPDATE TB_JDBC_BOARD"
				+ "		 SET TITLE = ?"
				+ "		   , CONTENT = ?"
				+ "	   WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		return JDBCUtil.update(sql, param);
	}


	public int deleteBoard(int boardNo) {
		String sql = "DELETE FROM TB_JDBC_BOARD"
				+ "	   WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		
		return JDBCUtil.update(sql, param);
	}


	public Map<String, Object> selectNewBoard() {
		String sql = "SELECT A.BOARD_NO"
				+ "		   , A.TITLE"
				+ "		   , A.CONTENT"
				+ "		   , B.MEM_NAME"
				+ "		   , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "	   WHERE A.BOARD_NO = ("
				+ "			SELECT MAX(BOARD_NO) FROM TB_JDBC_BOARD"
				+ ")";
		
		return JDBCUtil.selectOne(sql);
	}
	
	
}












