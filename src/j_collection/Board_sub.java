package j_collection;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;



public class Board_sub {

	static ArrayList<HashMap<String, Object>> teble = new ArrayList<HashMap<String, Object>>();
	static HashMap<String, Object> column = new HashMap<String, Object>();
	
//	static Scanner sc = new Scanner(System.in);
//	static String a = (sc.nextLine());
//	static String b = (sc.nextLine());
//	static String c = (sc.nextLine());

	
	
//	static String a = ScanUtil.nextLine();
//	static String b = ScanUtil.nextLine();
//	static String c = ScanUtil.nextLine();

	
	static String[] columnTit = {"번호","제목","작성자","작성일"};
	String[] columnCon = {"번호","제목","내용","작성자","작성일"};
	static String[] columnNum = {"번호"};
	
	String a;
	String b;
	String c;
	static int count=1;
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static String currentDate = dateFormat.format(new Date());
	
	Board_sub(String a, String b, String c){
		column = new HashMap<String, Object>();
		column.put("번호",Integer.toString(count++));
		column.put("제목",a);
		column.put("내용", b);
		column.put("작성자", c);
		column.put("작성일", currentDate);
		teble.add(column);
		
	}
	
	
	//컬럼목록 출력
	void board_column(){
	
		
	  for(int i=0; i<teble.size(); i++) {
		  column = teble.get(i);
		for(String key : columnTit) {
			System.out.print(column.get(key)+"\t");
			}
		System.out.println();
	  	}
	}
	
	
	//게시판 기능start
	static void start(){
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
							for(String key : columnNum ) {
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
							for(String key : columnNum ) {
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



