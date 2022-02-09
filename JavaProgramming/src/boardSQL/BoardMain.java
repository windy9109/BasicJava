package boardSQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class BoardMain {

	

	
	
	
	
	public static void main(String[] args) {
		
		
		
		//Oracle연동한 게시판만들기
//		String sql = "INSERT INTO TB_JDBC_BOARD"
//				+ " VALUES ("
//				+ "         (SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD)"
//				+ "			, ?, ?, ?"
//				+ "			SYSDATE"
//				+ " )";
		
			

			
			
		
		
	while(true) {
		//목록출력
		String sql = "select *" 
				+ " from TB_JDBC_BOARD"
				+ " ORDER BY REG_DATE";
		List<Map<String, Object>> list = BoardQuery.selectList(sql);
		String[] columntit1 = {"BOARD_NO","TITLE","MEM_ID","REG_DATE"};
		 
		
		System.out.println("                     [목 록]" 
		+ "\n-----------------------------------------------------");
		
		for (String key : columntit1) {
			System.out.print(key + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
	
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			map = list.get(i);
			for (String key : columntit1) {
				System.out.print(map.get(key) + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
		//조회번호 이외의 입력값을 받았을때 예외처리
		outer: while(true) {
			String sc = ScanUtil.nextLine();
			for(int i= 0; i< list.size(); i++) {
				if(sc.equals(String.valueOf(list.get(i).get("BOARD_NO")))) {
					System.out.println("\n상세페이지 조회성공!");
					
					//상세페이지 start
					map = list.get(i);
					String[] columntit2 = {"BOARD_NO","TITLE","CONTENT","MEM_ID","REG_DATE"};
					
					System.out.println("                      [상세페이지]" 
							+ "\n-----------------------------------------------------");
					for (String key : columntit2) {
						System.out.print(key + "\t");
					}
					System.out.println("\n-----------------------------------------------------");
				
					map = new HashMap<String, Object>();
						map = list.get(i);
						for (String key : columntit2) {
							System.out.print(map.get(key) + "\t");
						}
						System.out.println();
					
					//상세페이지 end

					
					
					System.out.println("게시물 수정은[1] 삭제는[2] 목록으로 돌아가려면[0]을 누르세요.");
					String container="0";	
					
					
					while(true) {
						container = ScanUtil.nextLine();
						if(container.equals("1") || container.equals("2") || container.equals("0")){
							
							break;
						}
						System.out.println("잘못입력했습니다");
					}
		

					//게시물 수정
					if(container.equals("1")){
						sql = "UPDATE TB_JDBC_BOARD "
								+ " SET TITLE = ?, CONTENT =?, MEM_ID=? "
								+ " WHERE BOARD_NO = ?";
						List<Object>param = BoardQuery.printUpdate(sc);
						int result = BoardQuery.Event(sql, param);
						System.out.println("게시물수정성공!");
						
						break outer;
						
						
						
					}

					//게시물 삭제
					
					if(container.equals("2")){
						System.out.println("게시물을 삭제하시겠습니까? y/n");
						while(true) {
							String scc = ScanUtil.nextLine();
							if(scc.equals("y") ||scc.equals("Y")) {
							
							sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
							List<Object>param = BoardQuery.printDelete(sc);
							int result = BoardQuery.Event(sql, param);
							System.out.println("게시물삭제성공!");

							//게시물 번호 재정렬
//							for(int j=0; j<list.size(); j++) {
//								sql="";
//							}
							//게시물 번호 재정렬 마침
							
							break outer;
							}else if(scc.equals("n") ||scc.equals("N")) {
								break outer;
							}else {
								System.out.println("잘못입력하셨습니다. 다시입력해주세요");
							}
						}
						
					}
					
					if(container.equals("0")){
						System.out.println("목록으로!");
						break outer;
					}
		
		}
				//insert문
				if(sc.equals("등록")) {
				sql = "INSERT INTO TB_JDBC_BOARD"
						+ " VALUES"
						+ " ((SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD),?,?,?,SYSDATE)";
				List<Object>param = BoardQuery.printInsert();
				int result = BoardQuery.Event(sql , param);
				System.out.println("등록성공!");
				break outer;
				}
			}
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
	  }
		
		
		

	}

  }
}
