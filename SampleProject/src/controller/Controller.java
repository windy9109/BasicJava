package controller;


import dao.MemberDao;
import service.BoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 발표내용: 조소개 > 주제소개 > 주제선정배경 > 메뉴구조 > 시연 프로젝트후기
		 * 발표인원: 발표자1명, ppt 및 시연도우미 1명
		 * 발표시간: 15분
		 * 
		 * Controller: 화면이동(컨트롤러에서만 서비스통제 - 중앙컨트롤형태)
		 * Service: 화면기능(메소드 집합)
		 * Dao: 데이터베이스 접속
		 * 
		 * 		
		*/		

		
		new Controller().start();
		
		
		
		
	}

	
	
	private MemberService memberService = MemberService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		int view = View.HOME;
		while(true) {
			switch(view) {
			
			case View.HOME: view = home(); break; 
			case View.LOGIN: view = MemberService.login(); break;
			case View.JOIN: view = MemberService.join(); break;
			case View.BOARD_LIST:  view = boardService.boardList(); break;
			}
		}
		
	}

	private int home() {
		System.out.println("1.로그인 2.회원가입 0.프로그램종료>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0:
			System.out.println("프로그램이 종료되었습니다");
			System.exit(0);
		}

		return View.LOGIN;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}



















