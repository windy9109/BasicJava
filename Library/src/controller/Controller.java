package controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import dao.NoticeBoardDao;
import service.BookService;
import service.ManageService;
import service.MemberService;
import service.NoticeBoardService;
import service.ReserveSevice;
import util.ScanUtil;
import util.View;

public class Controller {
	public static void main(String[] args) {
		new Controller().start(); //시작
	}
	
	
	public static Map<String, Object> LoginMember;
	private MemberService memberService = MemberService.getInstnace(); 
	private BookService bookService = BookService.getInstnace();
	private ReserveSevice reserveSevice = ReserveSevice.getInstnace();
	private NoticeBoardService noticeBoardService = NoticeBoardService.getInstnace();
	private NoticeBoardDao noticeBoardDao = NoticeBoardDao.getInstnace();
	private ManageService manageService = ManageService.getInstnace();
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	private void start() {
		int view = View.HOME;
		
		while(true) {
			switch(view) {
			case View.HOME://비회원 홈
				view = home();
				break;
			case View.MEMBERHOME: //회원 홈
				view = memberhome();
				break;
			case View.JOIN: //회원가입
				view = memberService.join();
				break;
				
			case View.LOGIN: //로그인
				view = memberService.login();
				break;
			case View.BOOK_SEARCH://도서검색
				view = bookService.bookSearch();
				break;
			case View.BOOK_NAME: //이름검색
				view = bookService.bookName();
				break;
			case View.BOOK_PROD: //분류검색
				view = bookService.bookProd();
				break;
			case View.BOOK_WRIRTER://저자검색
				view = bookService.bookWriter();
				break;
			case View.BOOK_PUB: //출판사 검색
				view = bookService.bookPub();
				break;
			case View.BOOK_PRODLIST://책 분류 검색리스트
				view = bookService.bookListProd();
				break;
			case View.BOOK_NAMELIST://책 도서명 검색 리스트
				view = bookService.bookListName();
				break;
			case View.BOOK_WRITERLIST: //책 저자 검색 리스트
				view = bookService.bookListWriter();
				break;
			case View.BOOK_PUBLIST:// 책 출판사 검색 리스트
				view = bookService.bookListPub();
				break;
			case View.BOOK_NAMEVIEW: //책 도서명 조회
				view = bookService.bookViewName();
				break;
			case View.BOOK_PRODVIEW: //책 도서명 조회
				view = bookService.bookViewProd();
				break;
			case View.BOOK_WRITERVIEW: //책 도서명 조회
				view = bookService.bookViewWriter();
				break;
			case View.BOOK_PUBVIEW: //책 도서명 조회
				view = bookService.bookViewPub();
				break;
			case View.NAMERESERVATION: //이름검색 예약
				view = reserveSevice.nameReservation();
				break;
			case View.WRITERRESERVATION: //저자검색 예약
				view = reserveSevice.writerReservation();
				break;
			case View.PRODRESERVATION: //분류검색 예약
				view = reserveSevice.prodReservation();
				break;
			case View.PUBRESERVATION: //출판사이름검색 예약
				view = reserveSevice.pubReservation();
				break;
			case View.LOGIN_PAGE: //로그인페이지
				view = loginPage();
				break;
			case View.MY_PAGE: //마이페이지
				view = myPage();
				break;
			case View.MY_VIEWRES://마이페이지 예약확인
				view = memberService.viewReservation();
				break;
			case View.MY_DELETRES: //마이페이지 예약취소
				view = memberService.deleteReservation();
				break;
			case View.MY_UPDATEMEMBER: //회원 정보 수정
				view = memberService.memberUpdate();
				break;
			case View.MY_UPDATEMENU: // 회원정보 수정 메뉴
				view = memberService.update();
				break;
			case View.MY_REPASS://회원 비밀번호 변경
				view = memberService.rePass();
				break;
			case View.MY_RENAME://회원 이름 변경
				view = memberService.reName();
				break;
			case View.MY_REPHONE://회원 전화번호 변경
				view = memberService.rePhone();
				break;
			case View.MY_READD:// 회원 주소 변경
				view = memberService.reAdd();
				break;
			case View.MY_REEMAIL:// 회원 이메일 변경
				view = memberService.reEmail();
				break;
			case View.NOTICEBOARD: //게시판 메뉴
				view = noticeBoard();
				break;
			case View.NOTICE_LIST://공지사항 게시판
				view = noticeBoardService.noticeList();
				break;
			case View.NOTICE_VIEW: //공지사항 조회
				view = noticeBoardService.noticView();
				break;
			case View.BOARD_LIST://자유게시판 
				view = noticeBoardService.boardList();
				break;
			case View.BOARD_VIEW: //자유게시판 조회
				view = noticeBoardService.boardView();
				break;
			case View.BOARD_INSERT:// 자유게시판 등록
				view = noticeBoardService.boardInsert();
				break;
			case View.BOARD_DELETE: // 자유게시판 삭제
				view = noticeBoardService.boardDelete();
				break;
			case View.BOARD_UPATE: // 자유게시판 수정
				view = noticeBoardService.boardUpdate();
				break;
			case View.MY_BOARD_LIST: // 내가쓴 자유게시판
				view = memberService.myBoardList();
				break;
			case View.MY_LOAN_LIST://마이페이지 대출현황
				view = memberService.myLoanList();
				break;
			case View.MANAGE_HOME: //관리자 모드
				view = managerHome();
				break;
			case View.BOOK_LIST_M: //관리자 책 조회
				view = manageService.bookListM();
				break;
			case View.RESERV_LIST_M: //관리자 예약 조회
				view = manageService.reservView();
				break;
			case View.BOOK_RENT_M:
				view = manageService.loanView();
				break;
			case View.BOARD_LIST_M:
				view = manageService.boardViewM();
				break;
			case View.F_BOARD_M:
				view = manageService.FboardListM();
				break;
			case View.F_BOARD_CONTENT_M:
				view = manageService.getContent();
				break;
			case View.NOTICE_BOARD_M:
				view = manageService.noticeBoardView();
				break;
			case View.NOTICE_VIEW_M:
				view = manageService.noticeManage();
				break;
				
			case View.REVIEW: //리뷰쓰기
				view = memberService.loanReview();
				break;
			case View.NOTICE_REGIST_M:
				view = manageService.noticeRegist();
				break;
			case View.VIEWREVIEW://리뷰 메뉴
				view = memberService.viewReview();
				break;
			case View.MY_REVIEW:
				view = memberService.my_Review();
				break;
			case View.MY_VIEW_REVIEW:
				view = memberService.my_viewRview();
				break;
			case View.REVIEW_INFO_M:
				view = manageService.MreviewInfo();
				break;
			case View.REVIEW_CHECK_M:
				view = manageService.MreviewCheck();
				break;
			case View.MY_VIEW:
				view = memberService.my_view();
				break;
			case View.MY_VIEWBOOK:
				view = memberService.MYboardView();
				break;
			case View.MY_DELETEBOOK:
				view = memberService.MYboardDelete();
				break;
			case View.MY_REBOOK:
				view = memberService.MYboardUpdate();
				break;
				
				
			}
		}
		
	}


	private int home() {
		//베스트
		
		
		//공지
		System.out.println("[공지사항 목록]___________________________________");
		List<Map<String, Object>> noticeList = noticeBoardDao.noticeList();
	
		System.out.println("글번호 \t 글제목 \t 작성일");
		System.out.println("------------------------------------------");
		for(int i = noticeList.size()-1; i>=noticeList.size()-3; i--) {
			Map<String, Object> notice = noticeList.get(i);
			System.out.print(notice.get("NOTICE_NO")+"\t");
			System.out.print(notice.get("NOTICE_TITLE")+"\t");
			System.out.println(format.format(notice.get("NOTICE_DATE")));
		}
		System.out.println("______________________________________________");
		
		System.out.print("1.로그인페이지 2.도서검색  3.게시판 0.프로그램 종료  > ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return View.LOGIN_PAGE; //메서드를 직접 설정하면 안됨 return만 해야함
		case 2:
			return View.BOOK_SEARCH;
		case 3:
			return View.NOTICEBOARD;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		
		
		return View.HOME;
		
	}
	
	private int memberhome() {
		//베스트
		
		
		//공지
		System.out.println("[공지사항 목록]___________________________________");
		List<Map<String, Object>> noticeList = noticeBoardDao.noticeList();
	
		System.out.println("글번호 \t 글제목 \t 작성일");
		System.out.println("------------------------------------------");
		for(int i = noticeList.size()-1; i>=noticeList.size()-3; i--) {
			Map<String, Object> notice = noticeList.get(i);
			System.out.print(notice.get("NOTICE_NO")+"\t");
			System.out.print(notice.get("NOTICE_TITLE")+"\t");
			System.out.println(format.format(notice.get("NOTICE_DATE")));
		}
		System.out.println("______________________________________________");
		
		
		System.out.print("1.로그인페이지 2.도서검색 3.게시판 4.마이페이지 0.프로그램 종료  > ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return View.LOGIN_PAGE; //메서드를 직접 설정하면 안됨 return만 해야함
		case 2:
			return View.BOOK_SEARCH;
		case 3:
			return View.NOTICEBOARD;
		case 4:
			return View.MY_PAGE;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			}
			return View.MEMBERHOME;
		}
	
	private int loginPage() {
		System.out.println("______________________________________________");
		System.out.print("1.로그인 2.회원가입 3.로그아웃 0.홈으로> ");
		int input = ScanUtil.nextInt();
		switch(input){
		case 1:
			return View.LOGIN;
		case 2:
			return View.JOIN;
		case 3:
			Controller.LoginMember = null;
			System.out.println("로그아웃 되셨습니다.");
			return View.HOME;
		case 0:
			if(LoginMember == null) {
				return View.HOME;
			}else {
			return View.MEMBERHOME;
			}
		}
		return View.LOGIN_PAGE;
	}
	
	private int myPage() {
		System.out.println("______________________________________________");
		System.out.print("1.예약 2.대출 3.회원정보수정 4.내가쓴글  5.내정보 0.홈으로> ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return View.MY_VIEWRES;
		case 2:
			return View.MY_LOAN_LIST;
		case 3:
			return View.MY_UPDATEMEMBER;
		case 4:
			return View.MY_BOARD_LIST;
		case 5:
			return View.MY_VIEW;
		case 0:
			return View.MEMBERHOME;
		}
		
		return View.MY_PAGE;
	}
	
	private int noticeBoard() {
		System.out.println("______________________________________________");
		System.out.print("1.공지사항 2.자유게시판 0.나가기 > ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return View.NOTICE_LIST;
		case 2:
			if(Controller.LoginMember == null) {
				System.out.println("로그인이 필요합니다.");
			}else {
				return View.BOARD_LIST;
			}
			
		case 0:
			if(Controller.LoginMember == null) {
				return View.HOME;
			}else {
				return View.MEMBERHOME;
			}
		}
		return View.NOTICEBOARD;
		
	}
	
	private int managerHome() {
		
		System.out.println("========================[관리자 모드]========================");
		System.out.print("1.도서관리 2.게시판관리 3.예약관리 4.대출관리 5.로그아웃 0.종료 > ");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.BOOK_LIST_M;
		case 2:
			return View.BOARD_LIST_M;
		case 3:
			return View.RESERV_LIST_M;
		case 4:
			return View.BOOK_RENT_M;
		case 5:
			LoginMember = null;
			return View.HOME;
		case 0:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		}
		
		return View.MANAGE_HOME;
		
	}
	
	
	
}
