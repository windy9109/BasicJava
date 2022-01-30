package j_collection;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;





public class Board {

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
		
		//목록
		
		

		
		ArrayList<HashMap<String, Object>> teble = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> column = new HashMap<String, Object>();
		String[] columnTit = {"번호","제목","작성자","작성일"};
		String[] containerTit = {"번호","제목","내용","작성자","작성일"};
		String[] columnnum = {"번호"};
		
		//원하는 날짜형식 지정함
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(new Date());
		
		
		//HashMap에 데이터 저장
		column = new HashMap<String, Object>();
		column.put("번호", Integer.toString(teble.size()+1));
		column.put("제목","제목명1");
		column.put("내용","내용출력란입니다.1");
		column.put("작성자","작성자명1");
		column.put("작성일", currentDate);
		teble.add(column);
		
		
		column = new HashMap<String, Object>();
		column.put("번호",Integer.toString(teble.size()+1));
		column.put("제목","제목명2");
		column.put("내용","내용출력란입니다2");
		column.put("작성자","작성자명2");
		column.put("작성일", currentDate);
		teble.add(column);
		
		column = new HashMap<String, Object>();
		column.put("번호",Integer.toString(teble.size()+1));
		column.put("제목","제목명3");
		column.put("내용","내용출력란입니다3");
		column.put("작성자","작성자명3");
		column.put("작성일", currentDate);
		teble.add(column);
		
		column = new HashMap<String, Object>();
		column.put("번호",Integer.toString(teble.size()+1));
		column.put("제목","제목명4");
		column.put("내용","내용출력란입니다4");
		column.put("작성자","작성자명4");
		column.put("작성일", currentDate);
		teble.add(column);
		
		
		

		
		
	while(true) {
		
		System.out.println("\n              [ 목록 ]");
		System.out.print("=====================================\n");
		for( String key : columnTit ) {
			System.out.print(key+"\t"); 
			}
		System.out.println("\n=====================================");

		
		for(int i=0; i<teble.size(); i++) {
			column =teble.get(i);
			for(String key : columnTit ) {
				System.out.print(column.get(key)+"\t");
			}
			System.out.println();
		}
		System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
		
		//목록조회부분
	
			//조회번호 이외의 입력값을 받았을때 예외처리
		outer: while(true) {
			String sc = ScanUtil.nextLine();
			for(int i= 0; i< teble.size(); i++) {
				
				if(sc.equals( teble.get(i).get("번호"))) {
					System.out.println("\n상세페이지 조회성공!");
					
					
					//상세페이지 start
					column = teble.get(i);

					
					System.out.print("=====================================\n");
					System.out.println("번호: "+column.get("번호")+" / 제목: "+column.get("제목"));
					System.out.print("-------------------------------------\n");
					System.out.println(column.get("내용")+"\n\n");
					System.out.println("\n-------------------------------------");
					System.out.println("작성자: "+column.get("작성자")+" / 작성일: "+column.get("작성일"));
					System.out.println("=====================================");
					//상세페이지 end
					
					System.out.println("게시물 수정은[1] 삭제는[2] 목록으로 돌아가려면[0]을 누르세요.");
					String container="0";						
					//입력체크
					while(true) {
						container = ScanUtil.nextLine();
						if(container.equals("1") || container.equals("2") || container.equals("0")){
							
							break;
						}
						System.out.println("잘못입력했습니다");
					}
					
					//게시물 수정
						if(container.equals("1")){
							
							System.out.println("수정할 게시물 제목을 입력해주세요");
							String a = ScanUtil.nextLine();
							System.out.println("수정할 게시물 내용을 입력해주세요");
							String b = ScanUtil.nextLine();
							System.out.println("수정할 작성자명을 입력해주세요");
							String c = ScanUtil.nextLine();
							column.put("번호", Integer.toString(teble.size()+1));
							column.put("제목", a);
							column.put("내용", b);
							column.put("작성자", c);
							column.put("작성일", currentDate);
							
							//게시물 번호 재정렬
							for(int j=0; j<teble.size(); j++) {
								column = teble.get(j);
								for(String key : columnnum ) {
									column.put(key,Integer.toString(j+1));
								}
							}
							//게시물 번호 재정렬 마침
							
							
							System.out.println("게시물수정성공!");
							break outer;
						}
						//게시물 삭제
						if(container.equals("2")){
							System.out.println("게시물삭제성공!");
							teble.remove(i);

							
							//게시물 번호 재정렬
							for(int j=0; j<teble.size(); j++) {
								column = teble.get(j);
								for(String key : columnnum ) {
									column.put(key,Integer.toString(j+1));
								}
							}
							//게시물 번호 재정렬 마침
							
							break outer;
						}
						//목록으로
						if(container.equals("0")){
							System.out.println("목록으로!");
							break outer;
						}
				}
				
				//등록
				if(sc.equals("등록")) {
						System.out.println("게시물 제목을 입력해주세요");
						String d = ScanUtil.nextLine();
						System.out.println("게시물 내용을 입력해주세요");
						String e = ScanUtil.nextLine();
						System.out.println("작성자명을 입력해주세요");
						String f = ScanUtil.nextLine();
						column = new HashMap<String, Object>();
						column.put("번호", Integer.toString(teble.size()+1));
						column.put("제목", d);
						column.put("내용", e);
						column.put("작성자", f);
						column.put("작성일", currentDate);
						teble.add(column);
						//teble.get(j) = 
					
					System.out.println("등록성공!");
					break outer;
				}
			}
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");	
			
		}
		

		
	 }
		
		
		
		
		
		
  }

}