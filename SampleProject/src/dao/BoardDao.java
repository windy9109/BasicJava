package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {

	//싱글톤패턴: 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private BoardDao() {
		
	}
	
	private static BoardDao instance; //객체를 보관할 변수
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	public List<Map<String, Object>> selectBoardList(){
		String sql ="SELECT A.BOARD_NO"
				+ "		, A.TITLE"
				+ "		, B.MEM_NAME"
				+ "		, TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MRM_ID"
				+ "		ORDER BY A.BOARD_NO DESC";
		
		return JDBCUtil.selectList(sql);
	}
	
	
	
}
