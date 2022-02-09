package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;
import k_jdbc.JDBCUtil;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new test01().start();
	}
	
	
	//Professor
	
	private void start() {
		while(true) {
			String sql ="SELECT A.BOARD_NO"
					+ "		, A.TITLE"
					+ "		, B.MEM_NAME"
					+ "		, TO_CHAR(A.REG_DATE,'MM/DD') AS REG_DATE"
					+ "	   FROM TB_JDBC_BOARD A"
					+ "		LEFT OUTER JOIN MEMBER B ON A.MEM_ID= B.MEM_ID"
					+ "		ORDER BY A.BOARD_NO";
		//	List<Map<String, Object>> boardList = JDBCUtil.seletList(sql);
			System.out.println("\n1.조회  2.등록  0.종료");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("종료됩니다");
				System.out.println(input);
				break;
			}
			
			
		}
	}
	
	
	
	
	private void insert() {
		System.out.println("제목>");
		String title = ScanUtil.nextLine();
		System.out.println("내용>");
		String content = ScanUtil.nextLine();
		System.out.println("작성자");
		String memId = ScanUtil.nextLine();
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ " VALUES ("
				+ "			(SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD)"
				+ "			,?,?,?"
				+ "			,SYSDATE"
				+ " )";
		
		List<Object> param =new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(memId);
		
		if(0<JDBCUtil.update6_1(sql, param)) {
			System.out.println("게시물등록이 완료되었습니다.");
		}else {
			System.out.println("게시물등록에 실패했습니다.");
		}
		
		
	}
	
	
	
	private void read() {
		System.out.println("게시글번호>");
		int boardNo = ScanUtil.nextInt();
		String sql ="SELECT A.BOARD_NO"
				+ "		, A.TITLE"
				+ "		, A.CONTENT"
				+ "		, B.MEM_NAME"
				+ "		, TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "		WHERE A.BOARD_NO=?";
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		
		Map<String, Object> board = JDBCUtil.selectOne2(sql, param);
		System.out.println("---------------------------------------");
		System.out.println("번호\t: "+board.get("BOARD_NO"));
		System.out.println("작성자\t: "+board.get("MEM_NAME"));
		System.out.println("작성일\t: " +board.get("REG_DATE"));
		System.out.println("내용\t: "+board.get("TITLE"));
		System.out.println("---------------------------------------");
		
		System.out.println("1.수정  2.삭제  0.목록");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			//update();
		}
		
	}
	
	
	
	
	
	
	
	
	

}
