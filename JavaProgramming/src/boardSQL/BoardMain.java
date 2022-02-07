package boardSQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j_collection.Board_sub;

public class BoardMain {

	public static void main(String[] args) {
		
		
		
		//Oracle연동한 게시판만들기
//		String sql = "INSERT INTO TB_JDBC_BOARD"
//				+ " VALUES ("
//				+ "         SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD"
//				+ "			, ?, ?, ?"
//				+ "			SYSDATE"
//				+ " )";
		
		
		
		
		
			
//			System.out.println("\n              [ 목록 ]");
//			System.out.print("=====================================\n");
//			for( String key : Board_sub.columnTit ) {
//				System.out.print(key+"\t"); }
//			System.out.println("\n=====================================");
//			column1.board_column();
//
//
//			System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
//			
//			//start
//			Board_sub.start();
			

			
			
		
		
	while(true) {
		//목록출력
		String sql = "select *" 
				+ " from TB_JDBC_BOARD";
		List<Map<String, Object>> list = BoardQuery.selectList(sql);
		String[] columntit = {"BOARD_NO","TITLE","CONTENT","MEM_ID","REG_DATE"};
		
		
		System.out.println("                     [목 록]" 
		+ "\n-----------------------------------------------------");
		
		for (String key : columntit) {
			System.out.print(key + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
	
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			map = list.get(i);
			for (String key : columntit) {
				System.out.print(map.get(key) + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
		
		System.out.println("\n\n");
		

		

		
		
		//insert문
		sql = "INSERT INTO TB_JDBC_BOARD"
				+ " VALUES"
				+ " ((SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD),?,?,?,SYSDATE)";
		List<Object>param = BoardQuery.print();
		int result = BoardQuery.insert(sql , param);
		System.out.println(result+"개의 행이 insert되었습니다.");
		
		
	}

		
		
		

		
		
		//게시판 목록 출력
		
		//등록기능
		
		
		
		//게시판 상세페이지 출력
		
		//수정기능
		
		//삭제기능(삭제할것인지 한번더 물어봄)
		
		
		
	
		
		

	}

}
