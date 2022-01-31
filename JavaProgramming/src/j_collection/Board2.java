package j_collection;


public class Board2 {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap를 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판을 저장할 컬럼(번호,제목,내용,작성자,작성일)
		 * 1. 목록띄우기 - 조회(상세페이지), 등록
		 * 2. 조회 - 수정,삭제기능
		 * 
		 * 
		*/
		
	Board_sub column1 = new Board_sub("제목명1", "내용출력란입니다.1", "작성자명1");
	Board_sub column2 = new Board_sub("제목명2", "내용출력란입니다.2", "작성자명2");
	Board_sub column3 = new Board_sub("제목명3", "내용출력란입니다.3", "작성자명3");
	Board_sub column4 = new Board_sub("제목명4", "내용출력란입니다.4", "작성자명4");
	
		
		
	while(true) {
		
		System.out.println("\n              [ 목록 ]");
		System.out.print("=====================================\n");
		for( String key : Board_sub.columnTit ) {
			System.out.print(key+"\t"); }
		System.out.println("\n=====================================");
		column1.board_column();


		System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
		
		//start
		Board_sub.start();
		

		
		}
		

		
		
		
	}

}