package util;

public interface View {
	int HOME = 0;//홈
	int LOGIN = 1;//로그인
	int JOIN = 2;//회원가입
	int BOOK_SEARCH = 3;//도서검색
	int BOOK_NAME = 4; // 이름검색
	int BOOK_PROD = 5; //분류검색
	int BOOK_WRIRTER = 6;//저자검색
	int BOOK_PUB = 7; // 출판사검색
	int BOOK_PRODLIST = 8; //책 분류 리스트
	int BOOK_NAMELIST = 9;//책 도서명 리스트
	int BOOK_WRITERLIST = 10;//책 저자명 리스트
	int BOOK_PUBLIST = 12; //책 출판사 리스트
	int BOOK_NAMEVIEW = 13;//책 조회
	int BOOK_PRODVIEW = 14;//책 조회
	int BOOK_WRITERVIEW = 15;//책 조회
	int BOOK_PUBVIEW = 16;//책 조회
	int NAMERESERVATION = 17; //도서명예약
	int WRITERRESERVATION = 18; //저자예약
	int PRODRESERVATION = 19; //분류예약
	int PUBRESERVATION = 20; //출판사예약
	int LOGIN_PAGE = 21; //로그인 페이지
	int MY_PAGE = 22; //마이페이지
	int MY_VIEWRES = 23; //마이페이지 예약확인
	int MY_DELETRES = 24; //마이페이지 예약 취소
	int MEMBERHOME = 25;//멤버 화면
	int MY_UPDATEMEMBER = 26; //회원정보 수정
	int MY_UPDATEMENU = 27; //회원정보 수정 메뉴
	int MY_REPASS = 28; //회원 이름 변경
	int MY_RENAME = 29; //회원 이름 변경
	int MY_REPHONE = 30; //회원 전화번호 변경
	int MY_READD = 31; //회원 주소 변경
	int MY_REEMAIL = 32; //회원 이메일 변경
	int NOTICEBOARD = 33; //게시판 메뉴
	int NOTICE_LIST = 34; //공지사항 리스트
	int NOTICE_VIEW = 35;//공지사항 조회
	int BOARD_LIST = 36; // 자유게시판 리스트
	int BOARD_VIEW = 37; // 자유게시판 조회
	int BOARD_INSERT = 38; //자유게시판 등록
	int BOARD_DELETE =39; // 자유게시판 삭제
	int BOARD_UPATE = 40; //자유게시판 수정
	int MY_BOARD_LIST = 41; //내가쓴 게시판
	int MY_LOAN_LIST = 42; //마이페이지 대출현황
	int REVIEW = 48; //리뷰작성
	
	
	
	int MANAGE_HOME = 43; //메니저 홈
	int BOOK_LIST_M = 44; // 메니저 책 리스트
	int BOARD_LIST_M = 45; //메니저 보드 리스트
	int RESERV_LIST_M = 46; // 메니저 예약
	int BOOK_RENT_M = 47; // 메니저 책 대출

	int F_BOARD_CONTENT_M = 49;
	int F_BOARD_M = 50;
	int NOTICE_BOARD_M = 51;
	int NOTICE_VIEW_M = 52;
	int NOTICE_REGIST_M = 53;
	
	int VIEWREVIEW = 54;//리뷰 메뉴
	int MY_REVIEW = 55;// 내가쓴 리뷰
	int MY_VIEW_REVIEW = 56; //내가쓴 리뷰 상세
	
	int REVIEW_INFO_M = 57;
	int REVIEW_CHECK_M = 58;
	
	int MY_VIEW = 59;
	
	int MY_VIEWBOOK = 60;
	int MY_DELETEBOOK = 61;
	int MY_REBOOK = 62;
	


}
