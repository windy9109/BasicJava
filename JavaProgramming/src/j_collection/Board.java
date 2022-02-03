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
		
		
		
//		ArrayList<HashMap<String, Object>> teble = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> column = new HashMap<String, Object>();
//		String[] columnTit = {"번호","제목","작성자"};
//		
//		for( String key : columnTit ) {
//			System.out.print(key+"\t");
//		}
		
		
		ArrayList<HashMap<String, Object>> teble = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> column = new HashMap<String, Object>();
		String[] columnTit = {"번호","제목","작성자","작성일"};
		String[] containerTit = {"번호","제목","내용","작성자","작성일"};
		
		//원하는 날짜형식 지정함
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(new Date());
		
		//HashMap에 데이터 저장
		column = new HashMap<String, Object>();
		column.put("번호","1");
		column.put("제목","제목명1");
		column.put("내용","내용출력란입니다.1");
		column.put("작성자","작성자명1");
		column.put("작성일", currentDate);
		teble.add(column);
		
		
		column = new HashMap<String, Object>();
		column.put("번호","2");
		column.put("제목","제목명2");
		column.put("내용","내용출력란입니다2");
		column.put("작성자","작성자명2");
		column.put("작성일", currentDate);
		teble.add(column);
		
		column = new HashMap<String, Object>();
		column.put("번호","3");
		column.put("제목","제목명3");
		column.put("내용","내용출력란입니다3");
		column.put("작성자","작성자명3");
		column.put("작성일", currentDate);
		teble.add(column);
		
		column = new HashMap<String, Object>();
		column.put("번호","4");
		column.put("제목","제목명4");
		column.put("내용","내용출력란입니다4");
		column.put("작성자","작성자명4");
		column.put("작성일", currentDate);
		teble.add(column);
		

		//목록조회부분
		
		while(true) {
			System.out.println("\n              [ 목록 ]");
			System.out.print("=====================================\n");
			for( String key : columnTit ) {
				System.out.print(key+"\t"); }
			System.out.println("\n=====================================");
			for(int i=0; i<teble.size(); i++) { //한행을 가져옴
				column = teble.get(i); //teble의 i번째 내용을 column에 넣는다. 한행 불러옴 
				for( String key : columnTit ) {	//columnTit을 key로 설정함. 컬럼임.
					System.out.print(column.get(key)+"\t"); //전체 값을 출력함
				}
				System.out.println();
			}
			
			
			//조회번호 이외의 입력값을 받았을때 예외처리
			System.out.println("\n조회하고 싶은 게시물의 번호를 입력해주세요.\n게시물 등록은 [등록]이라고 입력해주세요.");
			outer: while(true) {
				String sc = ScanUtil.nextLine();
				
					for(int i= 0; i< teble.size(); i++) {
						
						if(sc.equals( teble.get(i).get("번호"))) {
							System.out.println("\n상세페이지 조회성공!");
							
							
							//상세페이지 start
							column = teble.get(i);
//							for( String key : containerTit ) {
//								System.out.print(column.get(key)+"\t");
//							}
							
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
									System.out.println("게시물수정!");
									break outer;
								}
								//게시물 삭제
								if(container.equals("2")){
									System.out.println("게시물삭제!");
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
							System.out.println("등록성공!");
							break outer;
						}
					}
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");		
					
			}
		
		}
		
		//상세페이지 출력란
//		if( sc.equals(ta) ) {
//		for(int i=0; i<teble.size(); i++) {
//			for( String key : column.keySet() ) {
//				System.out.println(column.get(key)); //마지막으로 저장한키의 값을 불러옴
//			}
//		}
		
		
		// 게시판을 저장할 컬럼(번호,제목,내용,작성자,작성일)
		// 1. 목록띄우기 - 조회(상세페이지), 등록
		// 2. 조회 - 수정,삭제기능
		
		//목록 등록하기
		
		
		
		
		//System.out.println(teble.get(1).get("작성자"));
		
		
//		String [] num = new String[count];
//		for(int i=0; i<teble.size(); i++) {
//			column = teble.get(i); //teble의 i번째 내용을 column에 넣는다. 한행 불러옴 
//			for( String key : columnNum ) {	//columnTit을 key로 설정함. 컬럼임.
//				num[i] = column.get(key); //한행의 key값을 출력함	
//			}
//		}
		
		

		

//		if( sc > count ){
//			
//		}
		
//		for(int i=0; i<teble.size(); i++) {
//			column = teble.get(i);
//			for(String key : columnNum) {
//				System.out.println(column.containsKey(key));
//			}
//		}
		
//		System.out.println(column.get(columnNum));
		
		
//		while(true) {
//			System.out.println("조회하고 싶은 번호를 입력해주세요.");
//			String sc = ScanUtil.nextLine();
			
			
//			for(int i=0; i<teble.size(); i++) {
//				column = teble.get(i);  //한행을 column에 넣는다
//				for(int j=0; j<column.size(); j++) {
//					if(column.get("번호").equals(sc)){
//						//조회
//						break;						
//					}else {
//						System.out.println("잘못입력");
//						break;
//					}
//				}
//			}
//			break;
//		}
		
		
		
		
//		
//		ArrayList<ArrayList<String>> coulmn = new ArrayList<ArrayList<String>>();
//		
//		for(int i = 0; i<coulmn.size(); i++) {
//			for() {}
//			System.out.println();
//		}

		
//		column.put(columnTit[1],"1");
//		column.put(columnTit[2],"제목입니다.");
//		column.put(columnTit[3],"작성자명");
//		teble.add(column);
//		
//		column = new HashMap<String, Object>();
//		column.put(columnTit[1],"2");
//		column.put(columnTit[2],"제목입니다아");
//		column.put(columnTit[3],"작성자명~");
//		teble.add(column);
//		
//		
//		column = new HashMap<String, Object>();
//		column.put(columnTit[1],"2");
//		column.put(columnTit[2],"제목이예요");
//		column.put(columnTit[3],"작성자명!");
//		teble.add(column);
//		
		

		
//		Set<String> key2 = column.keySet();
//		for(int i=0; i<teble.size(); i++) {
//			column = teble.get(i);
//			for(String key : key2) {
//				System.out.print(column.get(key));
//			}
//			System.out.println();
//		}
			
		
		
		
		
//		ArrayList<HashMap<String, Object>> Teble = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> column = new HashMap<String, Object>();
//		
//		column.put("번호","1");
//		column.put("제목","제목출력하는 곳입니다.");
//		column.put("작성자","작성자명");
//		Teble.add(column);
//		
//		for( String key : column.keySet()  ) {
//			System.out.println(column.get(key));
//		}
		
		
		
		
		
//		ArrayList<HashMap<String, Object>> Teble = new ArrayList<HashMap<String, Object>>(); 
//		
//		HashMap<String, Object> column = new HashMap<String, Object>();
//		column.put("번호","1");
//		column.put("제목","제목출력입니다.");
//		column.put("작성자","작성자명");
//		Teble.add(column);
//		
//		for( String key : column.keySet()) {
//			System.out.println(column.get(key));
//		}
//		
		
		
		
//		//HashMap을 넣을 수있는 ArrayList인 Table를 만든다.
//		ArrayList<HashMap<String, Object>> Table = new ArrayList<HashMap<String, Object>>();
//		
//		//HashMap을 만든다.
//		HashMap<String, Object> column = new HashMap<String, Object>();
//		
//		//만들어진 HashMap의 column안에 key값과 내용을 넣는다.  
//		column.put("번호","1");
//		column.put("제목","제목입니다.");
//		column.put("작성자","작성자 입니다.");
//		//ArrayMap의 Table에 HashMap의 column의 내용을 넣는다 
//		Table.add(column);
//		
//		for(String key : column.keySet()) {
//			System.out.print(column.get(key));
//		}
		
		
		
		
		
//		ArrayList<HashMap<String, Object>> boardTeble = new ArrayList<HashMap<String, Object>>();
//		
//		HashMap<String, Object> column = new HashMap<String, Object>();
//		
//		for(int i= 0; i<10; i++) {
//			column = new HashMap<String, Object>();
//			column.put("번호",i);
//			column.put("제목",i+"제목을 출력합니다.");
//			column.put("작성자","작성자"+i);
//			boardTeble.add(column);
//			
//		}
//
//		
//		//System.out.println(column.keySet());
//		System.out.println("----------------------------");
//		System.out.println("     제목\t\t작성자\t번호");
//		System.out.println("----------------------------");
//		
//		for(int i=0; i<boardTeble.size(); i++) {
//			column = boardTeble.get(i);
//			for(String key : column.keySet()) {	
//				System.out.print(column.get(key)+"\t");
//			}
//			System.out.println();
//		}
		
		
		
		
		
	}

}
