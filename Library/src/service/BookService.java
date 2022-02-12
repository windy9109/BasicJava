package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BookDao;
import util.ScanUtil;
import util.View;

public class BookService {
	//싱글톤 패턴
			private BookService() {}
			private static BookService instance;
			public static BookService getInstnace() {
				if(instance == null) {
					instance= new BookService();
				}
				return instance;
			}
			
			
			private BookDao bookDao = BookDao.getInstnace();
			public static String bookno;
			String bprod;
			String bookName;
			String bookWriter;
			String bookPub;
			
			public int bookSearch() {
				System.out.println("[도서검색]__________________________________________");
				System.out.println("1.도서이름 2.분류 3.저자 4.출판사 0.나가기		 ");
				System.out.println("__________________________________________________");
				System.out.print("입력 > ");
				int input = ScanUtil.nextInt();
				
				switch(input) {
				case 1:
					return View.BOOK_NAME;
				case 2:
					return View.BOOK_PROD;
				case 3:
					return View.BOOK_WRIRTER;
				case 4:
					return View.BOOK_PUB;
				case 0:
					if(Controller.LoginMember == null) {
						return View.HOME;
					}
					else
					{
						return View.MEMBERHOME;
					}
					
				}
				return View.BOOK_SEARCH;
			}
			
			
			public int bookListProd() {
				
				
				List<Map<String, Object>> bookList = bookDao.searchBookProd(bprod);
				
				System.out.println("[도서 분류검색]_______________________________________");
				System.out.println("번호\t제목\t저자\t출판사");
				System.out.println("--------------------------------------------------");
				for(int i = 0; i < bookList.size(); i++) {
					Map<String , Object> board = bookList.get(i);
					System.out.print(board.get("BOOK_ID") + "\t");
					System.out.print(board.get("BOOK_NAME") + "\t");
					System.out.print(board.get("BOOK_WRITER") + "\t");
					System.out.println(board.get("BOOK_PUB") + "\t");
				}
				System.out.println("___________________________________________________");
				
				System.out.print("1.조회 0.나가기 > ");
				int input = ScanUtil.nextInt();
				
				switch(input) {
				case 1: //조회
					return View.BOOK_PRODVIEW;
				case 0://나가기
					return View.BOOK_SEARCH;
					
				}
				return View.BOOK_PRODLIST;
			}
				
			public int bookListName() {
					
					
				List<Map<String, Object>> bookList = bookDao.searchBookName(bookName);
					
				System.out.println("[도서명 검색]__________________________________________");
				System.out.println("번호\t제목\t저자\t출판사");
				System.out.println("----------------------------------------------------");
				for(int i = 0; i < bookList.size(); i++) {
					Map<String , Object> board = bookList.get(i);
					System.out.print(board.get("BOOK_ID") + "\t");
					System.out.print(board.get("BOOK_NAME") + "\t");
					System.out.print(board.get("BOOK_WRITER") + "\t");
					System.out.println(board.get("BOOK_PUB") + "\t");
				}
				System.out.println("_____________________________________________________");
					
				System.out.print("1.조회 0.나가기 > ");
				int input = ScanUtil.nextInt();
					
				switch(input) {
				case 1: //조회
					return View.BOOK_NAMEVIEW;
				case 0://나가기
					return View.BOOK_SEARCH;
						
				}
				return View.BOOK_NAMELIST;
			}
			
			public int bookListWriter() {
				
				
				List<Map<String, Object>> bookList = bookDao.searchBookWriter(bookWriter);
					
				System.out.println("[저자 검색]_____________________________________");
				System.out.println("번호\t제목\t저자\t출판사");
				System.out.println("--------------------------------------------------");
				for(int i = 0; i < bookList.size(); i++) {
					Map<String , Object> board = bookList.get(i);
					System.out.print(board.get("BOOK_ID") + "\t");
					System.out.print(board.get("BOOK_NAME") + "\t");
					System.out.print(board.get("BOOK_WRITER") + "\t");
					System.out.println(board.get("BOOK_PUB") + "\t");
				}
				System.out.println("__________________________________________________");
					
				System.out.print("1.조회 0.나가기 > ");
				int input = ScanUtil.nextInt();
					
				switch(input) {
				case 1: //조회
					return View.BOOK_WRITERVIEW;
				case 0://나가기
					return View.BOOK_SEARCH;
						
				}
				return View.BOOK_WRITERLIST;
			}
			
			public int bookListPub() {
				
				
				List<Map<String, Object>> bookList = bookDao.searchBookPub(bookPub);
					
				System.out.println("[도서 출판사 검색]_____________________________________");
				System.out.println("번호\t제목\t저자\t출판사");
				System.out.println("--------------------------------------------------");
				for(int i = 0; i < bookList.size(); i++) {
					Map<String , Object> board = bookList.get(i);
					System.out.print(board.get("BOOK_ID") + "\t");
					System.out.print(board.get("BOOK_NAME") + "\t");
					System.out.print(board.get("BOOK_WRITER") + "\t");
					System.out.println(board.get("BOOK_PUB") + "\t");
				}
				System.out.println("__________________________________________________");
					
				System.out.print("1.조회 0.나가기 > ");
				int input = ScanUtil.nextInt();
					
				switch(input) {
				case 1: //조회
					return View.BOOK_PUBVIEW;
				case 0://나가기
					return View.BOOK_SEARCH;
						
				}
				return View.BOOK_PUBLIST;
			}
			
			
			public int bookViewProd() {
	
				System.out.println("[조회]______________________________________________");
				
				System.out.print("조회할 게시물 번호>");
				String bookNo = ScanUtil.nextLine();
				bookno=bookNo;
	
				Map<String, Object> board = bookDao.bookView(bookNo);
					
				System.out.println("====================================================");
				System.out.println("책번호\t: " + board.get("BOOK_ID"));
				System.out.println("책이름\t: " + board.get("BOOK_NAME"));
				System.out.println("작성자\t: " + board.get("BOOK_WRITER"));
				System.out.println("출판사\t: " + board.get("BOOK_PUB"));
				System.out.println("위치\t: " + board.get("BPROD_LOC"));
				System.out.println("가능여부\t: " + board.get("RESERVE"));
				System.out.println("=====================================================");
				
				List<Map<String,Object>> review = bookDao.bookReview(bookNo);
				
				for(int i = review.size() - 1 ; i >= 0 ; i-- ) {
					Map<String, Object> re = review.get(i);
					System.out.print("별점: " + re.get("REVIEW_STAR"));
					System.out.println("\t내용 : " + re.get("REVIEW_CONTENT"));
					
				}
				System.out.println("=====================================================");
				
				System.out.print("1.예약 0.나가기 > ");
				int input = ScanUtil.nextInt();
				switch(input) {
				case 1:
					return View.PRODRESERVATION;
				case 2:
					return View.BOOK_PRODLIST;
				}
				return View.BOOK_PRODLIST;
			}
				
				public int bookViewWriter() {
					
					System.out.println("[조회]______________________________________________");
					
					System.out.print("조회할 게시물 번호>");
					String bookNo = ScanUtil.nextLine();
					bookno=bookNo;
					bookDao.bookView(bookNo);
						
					Map<String, Object> board = bookDao.bookView(bookNo);
						
					System.out.println("=====================================================");
					System.out.println("책번호\t: " + board.get("BOOK_ID"));
					System.out.println("책이름\t: " + board.get("BOOK_NAME"));
					System.out.println("작성자\t: " + board.get("BOOK_WRITER"));
					System.out.println("출판사\t: " + board.get("BOOK_PUB"));
					System.out.println("위치\t: " + board.get("BPROD_LOC"));
					System.out.println("가능여부\t: " + board.get("RESERVE"));
					System.out.println("=====================================================");
					
					List<Map<String,Object>> review = bookDao.bookReview(bookNo);
					
					for(int i = review.size() - 1 ; i >= 0 ; i-- ) {
						Map<String, Object> re = review.get(i);
						System.out.print("별점: " + re.get("REVIEW_STAR"));
						System.out.println("\t내용 : " + re.get("REVIEW_CONTENT"));
						
					}
					
					
					
					System.out.print("1.예약 0.나가기 > ");
					int input = ScanUtil.nextInt();
					switch(input) {
					case 1:
						
						return View.WRITERRESERVATION;
					case 2:
						return View.BOOK_WRITERLIST;
					}
				
				
				return View.BOOK_WRITERLIST;
			}
				
				public int bookViewName() {
					
					System.out.println("[조회]______________________________________________");
					
					System.out.print("조회할 게시물 번호>");
					String bookNo = ScanUtil.nextLine();
					bookno=bookNo;
					bookDao.bookView(bookNo);
						
					Map<String, Object> board = bookDao.bookView(bookNo);
						
					System.out.println("=====================================================");
					System.out.println("책번호\t: " + board.get("BOOK_ID"));
					System.out.println("책이름\t: " + board.get("BOOK_NAME"));
					System.out.println("작성자\t: " + board.get("BOOK_WRITER"));
					System.out.println("출판사\t: " + board.get("BOOK_PUB"));
					System.out.println("위치\t: " + board.get("BPROD_LOC"));
					System.out.println("가능여부\t: " + board.get("RESERVE"));
					System.out.println("=====================================================");
					
					List<Map<String,Object>> review = bookDao.bookReview(bookNo);
					
					for(int i = review.size() - 1 ; i >= 0 ; i-- ) {
						Map<String, Object> re = review.get(i);
						System.out.print("별점: " + re.get("REVIEW_STAR"));
						System.out.println("\t내용 : " + re.get("REVIEW_CONTENT"));
						
					}
					
					System.out.print("1.예약 0.나가기 > ");
					int input = ScanUtil.nextInt();
					switch(input) {
					case 1:
						return View.NAMERESERVATION;
					case 2:
						return View.BOOK_NAMELIST;
					}
				
				
				return View.BOOK_NAMELIST;
			}
				public int bookViewPub() {
					
					System.out.println("[조회]______________________________________________");
					
					System.out.print("조회할 게시물 번호>");
					String bookNo = ScanUtil.nextLine();
					bookno=bookNo;
					bookDao.bookView(bookNo);
						
					Map<String, Object> board = bookDao.bookView(bookNo);
						
					System.out.println("=====================================================");
					System.out.println("책번호\t: " + board.get("BOOK_ID"));
					System.out.println("책이름\t: " + board.get("BOOK_NAME"));
					System.out.println("작성자\t: " + board.get("BOOK_WRITER"));
					System.out.println("출판사\t: " + board.get("BOOK_PUB"));
					System.out.println("위치\t: " + board.get("BPROD_LOC"));
					System.out.println("가능여부\t: " + board.get("RESERVE"));
					System.out.println("=====================================================");
					
					List<Map<String,Object>> review = bookDao.bookReview(bookNo);
					
					for(int i = review.size() - 1 ; i >= 0 ; i-- ) {
						Map<String, Object> re = review.get(i);
						System.out.print("별점: " + re.get("REVIEW_STAR"));
						System.out.println("\t내용 : " + re.get("REVIEW_CONTENT"));
						
					}
					
					System.out.print("1.예약 0.나가기 > ");
					int input = ScanUtil.nextInt();
					switch(input) {
					case 1:
						return View.PUBRESERVATION;
					case 2:
						return View.BOOK_PUBLIST;
					}
				
				
				return View.BOOK_PUBLIST;
			}
				

			public int bookName() {
				System.out.println("[도서명 검색]______________________________________________");
				System.out.print("도서명 > ");
				bookName = ScanUtil.nextLine();
				Map<String,Object> param = new HashMap<>();
				param.put("BOOK_NAME", bookName);
				bookDao.searchBookName(bookName);
				
				
				return View.BOOK_NAMELIST;
			}
			
			
			public int bookProd() {
				System.out.println("[분류별 검색]______________________________________________");
				System.out.println("1.철학 2.종교 3.예술 4.언어 5.문학 6.역사 7.과학0.나가기");
				System.out.println("입력 > ");
				int input = ScanUtil.nextInt();
				
				switch(input) {
				case 1: case 2: case 3: case 4:
				case 5: case 6: case 7:
					bookBprod(input);
					return View.BOOK_PRODLIST;
				case 0:
					return View.BOOK_SEARCH;
				
				
				}
				
				return View.BOOK_PROD;
			}
			public int bookBprod(int input) {
				if(input == 1) {
					bprod = "100";
				}else if(input == 2) {
					bprod = "200";
				}else if(input == 3) {
					bprod = "300";
				}else if(input == 4) {
					bprod = "400";
				}else if(input == 5) {
					bprod = "500";
				}else if(input == 6) {
					bprod = "600";
				}else if(input == 7) {
					bprod = "700";
				}
				
				Map<String,Object> param = new HashMap<>();
				param.put("BPROD_ID", bprod);
				bookDao.searchBookProd(bprod);
				
				return View.BOOK_PRODLIST;
			}
			
			public int bookWriter() {
				System.out.println("[저자명 검색]______________________________________________");
				System.out.print("저자명 > ");
				bookWriter = ScanUtil.nextLine();
				Map<String,Object> param = new HashMap<>();
				param.put("BOOK_WRITER", bookWriter);
				bookDao.searchBookWriter(bookWriter);
				
				
				return View.BOOK_WRITERLIST;
			}
			
			public int bookPub() {
				System.out.println("[출판사 검색]______________________________________________");
				System.out.print("출판사명 > ");
				bookPub = ScanUtil.nextLine();
				Map<String,Object> param = new HashMap<>();
				param.put("BOOK_PUB", bookPub);
				bookDao.searchBookPub(bookWriter);
				
				
				return View.BOOK_PUBLIST;
			}
			
			
			
			
			
		
			
			
}
