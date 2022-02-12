package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDao;
import dao.NoticeBoardDao;
import util.RegularUtil;
import util.ScanUtil;
import util.View;

public class MemberService {
	//싱글톤 패턴
		private MemberService() {}
		private static MemberService instance;
		public static MemberService getInstnace() {
			if(instance == null) {
				instance= new MemberService();
			}
			return instance;
		}
		
		private MemberDao memberDao = MemberDao.getInstnace();
		private NoticeBoardDao noticeBoardDao = NoticeBoardDao.getInstnace();
		
		String boardno;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		boolean bl;
		String memId;
		String memPass;
		String memName;
		String memBir;
		String memPhone;
		String memAdd;
		String memEmail;
		
		
		public int join() {
			System.out.println("회원가입]_____________________________________________");
			
			
			System.out.println("아이디(영어소문자와 숫자 특수문자 (-,_)만 가능 4~10자리) ");
			System.out.print("아이디 입력 > ");
			memId = ScanUtil.nextLine();
			memId(memId);

			System.out.println("비밀번호(영어소문자와 숫자 특수문자 (~,!,@)만 가능 4~20자리) ");
			System.out.print("비밀번호 입력 > ");
			memPass = ScanUtil.nextLine();
			memPass(memPass);
			
			System.out.println("이름(한글 3~5자리) ");
			System.out.print("이름 입력 > ");
			memName = ScanUtil.nextLine();
			memName(memName);

			System.out.println("핸드폰번호 -빼고 입력(ex 01012345678)");
			System.out.print("핸드폰번호 입력 > ");
			memPhone = ScanUtil.nextLine();
			memPhone(memPhone);
			
			System.out.println("주소(도로명 주소로 기재) ");
			System.out.print("주소 입력 > ");
			memAdd = ScanUtil.nextLine();
			memAdd(memAdd);
			
			System.out.println("이메일(영어 4~10자 @ 영어4~10자.[com,org,co.kr]) ");
			System.out.print("이메일 입력 > ");
			memEmail = ScanUtil.nextLine();
			memEmail(memEmail);
		
			
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_ID", this.memId);
			param.put("MEM_NAME", this.memName);
			param.put("MEM_PHONE", this.memPhone);
			param.put("MEM_ADD", this.memAdd);
			param.put("MEM_EMAIL", this.memEmail);
			param.put("MEM_PASS", this.memPass);
			param.put("MEM_LCN", 3);
			
			int result = memberDao.insertMember(param);
			
			if(0 < result) {
			System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			return View.HOME;
		}
		
	
		
		public void memId(String memId) {

			bl = RegularUtil.idRegular(memId);
			List<Object> param = new ArrayList<>();
			param.add(memId);
			
			Map<String, Object> si = memberDao.searchID(param);
			
			
			while(bl == false || si.get("MEM_ID").equals(memId)) {
				if(si.get("MEM_ID").equals(memId)) {
					System.out.println("중복된 ID입니다.");
				}
				System.out.println("영어 소문자 4~10자리와 숫자로 다시 입력 해주세요.");
				System.out.print("아이디  입력> ");
				memId = ScanUtil.nextLine();
				bl = RegularUtil.idRegular(memId);
				
			}
			if(bl) {
				this.memId = memId;
			}
			

		}
			
		public void memPass(String memPass) {
	
			bl = RegularUtil.passRegular(memPass);
			
			while(bl == false) {
				System.out.println("잘못 입력 하셨습니다. 영어 소문자 4~10자리와 숫자만 가능 합니다.");
				System.out.print("비밀번호  입력> ");
				 memPass = ScanUtil.nextLine();
				bl = RegularUtil.passRegular(memPass);
				}
			if(bl) {
				this.memPass = memPass;
			}

			

		}	
		public void memName(String memName) {

			bl = RegularUtil.nameRegular(memName);
			
			while(bl == false) {
				System.out.println("잘못 입력 하셨습니다. 한글 3~5자리만 가능 합니다.");
				System.out.print("이름  입력> ");
				 memName = ScanUtil.nextLine();
				bl = RegularUtil.nameRegular(memName);
				}
			if(bl) {
				this.memName = memName;
			}
			
		}	

		public void memPhone(String memPhone) {

			bl = RegularUtil.phoneRegular(memPhone);
			
			while(bl == false) {
				System.out.println("잘못 입력 하셨습니다. ex01012345678");
				System.out.print("핸드폰번호  입력> ");
				 memPhone = ScanUtil.nextLine();
				bl = RegularUtil.phoneRegular(memPhone);
				}
			
			if(bl) {
				this.memPhone = memPhone;
			}
		}
		
		public void memAdd(String memAdd) {
			
			
			bl = RegularUtil.addRegular(memAdd);
			
			while(bl == false) {
				System.out.println("잘못 입력 하셨습니다. 한글 3~5자리만 가능 합니다.");
				System.out.print("주소  입력> ");
				 memAdd = ScanUtil.nextLine();
				bl = RegularUtil.addRegular(memAdd);
				}
			if(bl) {
				this.memAdd = memAdd;
			}
			
		}
		public void memEmail(String memEmail) {
			
			bl = RegularUtil.emailRegular(memEmail);
			
			while(bl == false) {
				System.out.println("잘못 입력 하셨습니다. 영어 4~20자 @ 영어4~20자.[com,org,co.kr]만 가능 합니다.");
				System.out.print("이메일  입력> ");
				 memEmail = ScanUtil.nextLine();
				bl = RegularUtil.emailRegular(memEmail);
				}
			if(bl) {
				this.memEmail= memEmail;
			}
			
		}
		
		public int login() {
			System.out.println("[로그인]________________________________________");
			System.out.println("아이디 > ");
			String memId = ScanUtil.nextLine();
			System.out.println("비밀번호 > ");
			String memPass = ScanUtil.nextLine();
			
			Map<String, Object> member = memberDao.selectMember(memId,memPass);

			if(member == null) {
				System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			}else if(member.get("MEM_ID").equals("SYSTEM")) {
				System.out.println("관리자로 로그인 하셨습니다.");
				Controller.LoginMember = member;
				return View.MANAGE_HOME;
			}else {
				System.out.println("로그인 성공");
				
				Controller.LoginMember = member;
				return View.MEMBERHOME;
			}
			
			return View.LOGIN_PAGE;
		}
		
		public int viewReservation() {

			List<Map<String, Object>> reservationList = memberDao.viewReservation(Controller.LoginMember);
			System.out.println("[예약 현황]__________________________________________");
			System.out.println("예약번호\t책번호\t제목\t예약일");
			System.out.println("--------------------------------------------------");
			for(int i = 0; i < reservationList.size(); i++) {
				Map<String , Object> viewRes = reservationList.get(i);
				System.out.print(viewRes.get("RES_ID") + "\t");
				System.out.print(viewRes.get("BOOK_ID") + "\t");
				System.out.print(viewRes.get("BOOK_NAME") + "\t");
				System.out.println(format.format(viewRes.get("RES_DATE")) + "\t");
			}
			System.out.println("==================================================");
			System.out.println("1.예약취소 0.홈으로");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				return View.MY_DELETRES;
			case 0:
				return View.MY_PAGE;

			}

			return View.MY_PAGE;
		}
		
		public int deleteReservation() {
			System.out.println("___________________________________________________");
			System.out.println("취소할 예약 번호> ");
			String input = ScanUtil.nextLine();
			System.out.println("정말 취소하시겠습니까(y,n)? >");
			String answer = ScanUtil.nextLine();
			Map<String, Object> param = new HashMap<>();
			param.put("RES_ID",input);
			param.put("BOOK_ID" , memberDao.selectBook_Id(param).get("BOOK_ID"));

			switch(answer) {
			case "y":{
				memberDao.deleteDReservation(param);
				memberDao.deleteReservation(param);
				memberDao.updateQty(param);
				
				System.out.println("취소 되었습니다.");
				return View.MY_VIEWRES;
				}
			case "n":
				return View.MY_VIEWRES;

			}

			return View.MY_VIEWRES;
		}
		
		public int memberUpdate() {
			System.out.println("[회원번호 수정]______________________________________");
			System.out.print("본인 확인을 위해 비밀번호를 입력해주세요 > ");
			String password = ScanUtil.nextLine();
			
			if(password.equals(Controller.LoginMember.get("MEM_PASS"))) {
				return View.MY_UPDATEMENU;
			}
			else {
				System.out.println("비밀번호를 잘못 입력 하셨습니다.");
				return View.MY_PAGE;
			}
		}
		
		public int update() {
			System.out.println("_________________________________________________");
			System.out.println("1.비밀번호 2.이름 3.전화번호 4.주소 5.이메일 0.뒤로가기");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1:
				return View.MY_REPASS;
			case 2:
				return View.MY_RENAME;
			case 3:
				return View.MY_REPHONE;
			case 4:
				return View.MY_READD;
			case 5:
				return View.MY_REEMAIL;
				
			case 0:
				return View.MY_PAGE;
			}
			
			return View.MY_UPDATEMENU;
		}
		
		
		public int rePass() {
			System.out.println("_________________________________________________");
			System.out.print("수정할 비밀번호 > ");
			String repass = ScanUtil.nextLine();
			System.out.print("비밀번호 확인 > ");
			String repass1 = ScanUtil.nextLine();
			
			if(repass.equals(repass1)) {
				Map<String, Object> param = new HashMap<>();
				param.put("MEM_PASS", repass);
				param.put("MEM_ID", Controller.LoginMember.get("MEM_ID"));
				memberDao.rePass(param);
				System.out.println("수정이 완료되었습니다.");
				return View.MY_UPDATEMEMBER;	
			}
			else {
				System.out.println("비밀번호가 서로 다릅니다.");
				return View.MY_UPDATEMENU;
			}
		}
		
		public int reName() {
			System.out.println("________________________________________________");
			System.out.print("수정할 이름 > ");
			String rename = ScanUtil.nextLine();
			
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_NAME", rename);
			param.put("MEM_ID", Controller.LoginMember.get("MEM_ID"));
			
			memberDao.reName(param);
			
			return View.MY_UPDATEMENU;
		}
		public int rePhone() {
			System.out.println("________________________________________________");
			System.out.print("수정할 전화번호(-없이) > ");
			String rephone = ScanUtil.nextLine();
			
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_PHONE", rephone);
			param.put("MEM_ID", Controller.LoginMember.get("MEM_ID"));
			
			memberDao.rePhone(param);
			
			return View.MY_UPDATEMENU;
		}
		public int reAdd() {
			System.out.println("________________________________________________");
			System.out.print("수정할 주소 > ");
			String readd = ScanUtil.nextLine();
			
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_ADD", readd);
			param.put("MEM_ID", Controller.LoginMember.get("MEM_ID"));
			
			memberDao.reAdd(param);
			
			return View.MY_UPDATEMENU;
		}
		public int reEmail() {
			System.out.println("________________________________________________");
			System.out.print("수정할 주소 > ");
			String reemail = ScanUtil.nextLine();
			
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_EMAIL", reemail);
			param.put("MEM_ID", Controller.LoginMember.get("MEM_ID"));
			
			memberDao.reEmail(param);
			
			return View.MY_UPDATEMENU;
		}
		
		public int myBoardList() {
			System.out.println("[내가 쓴 글 목록]___________________________________");
		
			List<Object> param = new ArrayList<>();
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			List<Map<String, Object>> boardList = memberDao.boardList(param);
		
			System.out.println("글번호 \t 글제목 \t 작성일");
			System.out.println("-------------------------------------------------");
			for(int i = boardList.size()-1; i>=0; i--) {
				Map<String, Object> notice = boardList.get(i);
				System.out.print(notice.get("BOARD_NO")+"\t");
				System.out.print(notice.get("BOARD_TITLE")+"\t");
				System.out.println(format.format(notice.get("BOARD_DATE")));
			}
			System.out.println("_________________________________________________");
			System.out.print("1.조회 0.뒤로가기 > ");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				return View.MY_VIEWBOOK;
			case 0:
				return View.MY_PAGE;
			}
			
			return View.MY_PAGE;
		}
		public int myLoanList() {
			System.out.println("[대출 목록]_______________________________________________________________________");
		
			List<Object> param = new ArrayList<>();
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			
			List<Map<String, Object>> loanList = memberDao.LoanList(param);
			
		
			System.out.println("대출번호 \t 책제목 \t 빌린날짜 \t 반납예정일 \t 반납일  \t 반납여부");
			System.out.println("--------------------------------------------------------------------------------");
			for(int i = loanList.size()-1; i>=0; i--) {
				Map<String, Object> notice = loanList.get(i);
				System.out.print(notice.get("LOAN_ID")+"\t");
				System.out.print(notice.get("BOOK_NAME")+"\t");
				System.out.print(format.format(notice.get("LOAN_DATE"))+"\t");
				System.out.print(format.format(notice.get("RETURN_DUE"))+"\t");
				
				System.out.print(notice.get("LOAN_RETURN")+"\t");
				System.out.println(notice.get("LOAN_CHK"));
				

			}
			System.out.println("______________________________________________________________________________________");
			System.out.print("1.리뷰 0.뒤로가기 > ");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				return View.VIEWREVIEW;
			case 0:
				return View.MY_PAGE;
			}
			
			return View.MY_PAGE;
		}
		public int viewReview() {
			System.out.print("1.리뷰작성 2.내가쓴리뷰 0.뒤로가기 > ");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1:
				return View.REVIEW;
			case 2:
				return View.MY_REVIEW;
			case 0:
				return View.MY_LOAN_LIST;
			}
			
			return View.MY_LOAN_LIST;
		}
		
		public int my_Review() {
			System.out.println("[리뷰 목록]___________________________________________________________________");
			
			List<Object> param = new ArrayList<>();
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			List<Map<String, Object>> reviewList = memberDao.reviewList(param);
			
			System.out.println("리뷰번호 \t 별점 \t 내용 \t 책이름 ");
			System.out.println("--------------------------------------------------------------------------------");
			for(int i = reviewList.size()-1; i>=0; i--) {
				Map<String, Object> review = reviewList.get(i);
				System.out.print(review.get("REVIEW_NO")+"\t");
				System.out.print(review.get("REVIEW_STAR")+"\t");
				System.out.print(review.get("REVIEW_CONTENT")+"\t");
				System.out.println(review.get("BOOK_NAME")+"\t");
				

			}
			System.out.println("______________________________________________________________________________________");
			System.out.print("1.조회 0.뒤로가기 > ");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1: 
				return View.MY_VIEW_REVIEW ;
			case 0:
				return View.VIEWREVIEW;
			}
			return View.VIEWREVIEW;
			
		}
		
		

		public int loanReview() {
			System.out.println("___________________________________________________");
			System.out.print("대출번호 > ");
			String input = ScanUtil.nextLine();
		
			Map<String, Object> bookno = memberDao.loanSearchBook(input);
			try {
			if(bookno.get("LOAN_CHK").equals("반납확인")) {
			
			System.out.print("별점(1~5 중 입력) > ");
			int star = ScanUtil.nextInt();
			
			String starPoint = "";
			if(star == 1) {
				starPoint = "★";
			}
			if(star == 2) {
				starPoint = "★★";
			}
			if(star == 3) {
				starPoint = "★★★";
			}
			if(star == 4) {
				starPoint = "★★★★";
			}
			if(star == 5) {
				starPoint = "★★★★★";
			}
			
			
			System.out.print("리뷰 : ");
			String review = ScanUtil.nextLine();
			

			List<Object> param = new ArrayList<>();
			param.add(review); //내용
			param.add(starPoint); //별점(정수)
			param.add(bookno.get("BOOK_ID"));
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			
			if(0 <memberDao.insertReview(param)) {
				System.out.println("리뷰가 작성되었습니다.");
				
				}else {
					System.out.println("리뷰등록에 실패 하셨습니다.");
					}
			
			}else {
				System.out.println("반납후 작성하세요.");
			}
			
			return View.MY_LOAN_LIST;
			}catch (Exception e) {
				System.out.println("반납후 작성하세요.");
				return View.MY_LOAN_LIST;
			}
		}
		
		public int my_viewRview() {
			System.out.print("조회할 리뷰의 번호 > ");
			String reviewNo = ScanUtil.nextLine();
			List<Object> param = new ArrayList<>();
			param.add(reviewNo);
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			Map<String, Object> review = memberDao.Dreview(param);			
			System.out.println("=====================================================");	
			System.out.println("리뷰번호: " + review.get("REVIEW_NO"));
			System.out.println("책이름: " + review.get("BOOK_NAME"));
			System.out.println("별점: " + review.get("REVIEW_STAR"));
			System.out.println("내용 : " + review.get("REVIEW_CONTENT"));
			System.out.println("=====================================================");
			System.out.print("0.뒤로가기 > ");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 0: 
				return View.MY_REVIEW;
			}
			return View.MY_REVIEW;
		}
		
		public int my_view() {
				
				List<Object> param = new ArrayList<>();
				
				param.add(Controller.LoginMember.get("MEM_ID"));
				
				Map<String, Object> view = memberDao.my_view(param);			
				System.out.println("=====================================================");	
				System.out.println("아이디: " + view.get("MEM_ID"));
				System.out.println("비밀번호: " + view.get("MEM_PASS"));
				System.out.println("이름: " + view.get("MEM_NAME"));
				System.out.println("전화번호 : " + view.get("MEM_PHONE"));
				System.out.println("주소 : " + view.get("MEM_ADD"));
				System.out.println("이메일 : " + view.get("MEM_EMAIL"));
				System.out.println("대출가능 횟수 : " + view.get("MEM_LCN"));
				System.out.println("=====================================================");
				System.out.print("0.뒤로가기 > ");
				int input = ScanUtil.nextInt();
				switch(input) {
				case 0: 
					return View.MY_PAGE;
				}
				return View.MY_PAGE;
			
		}
		
		
		public int MYboardView() {
			System.out.print("조회할 게시물 번호 >>");
			String boardNo = ScanUtil.nextLine();
			boardno = boardNo;
			
			List<Object> p = new ArrayList<>();
			p.add(boardNo);
			
			Map<String, Object> board = noticeBoardDao.boardView(p);
			
			System.out.println("[자유게시판 조회]________________________");
			System.out.println("글번호\t: "+board.get("BOARD_NO"));
			System.out.println("제목\t: "+board.get("BOARD_TITLE"));
			System.out.println("작성일\t: "+format.format(board.get("BOARD_DATE")));
			System.out.println("작성자\t: "+board.get("MEM_ID"));
			System.out.println("내용\t: "+board.get("BOARD_CONTENT"));
			System.out.println("_______________________________________");
			System.out.print("1.수정 2.삭제 0.목록 >>");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1:
				return View.MY_REBOOK;
			case 2:
				return View.MY_DELETEBOOK;
			case 0:
				return View.MY_BOARD_LIST;
			}
			return View.MY_BOARD_LIST;
		}
		
		public int MYboardDelete() {
			System.out.println("[자유게시판 삭제]________________________");
			System.out.print("정말 삭제하겠습니까? (y/n) >>");
			String yn = ScanUtil.nextLine();
			
			switch(yn) {
			
			case "y":
				List<Object> param = new ArrayList<>();
				param.add(boardno);
				param.add(Controller.LoginMember.get("MEM_ID"));
				
				if(0 < noticeBoardDao.boardDelete(param)) {
					System.out.println("삭제되었습니다.");
					break;
				}else {
					System.out.println("권한이 없습니다.");
				}
				
				
			case "n":
				System.out.println("삭제를 취소했습니다.");
				break;
			}
			
			return View.MY_BOARD_LIST;
		}
		
		public int MYboardUpdate() {
			
			System.out.println("[자유게시판 수정]________________________");
			System.out.print("[제목] >>");
			String title = ScanUtil.nextLine();
			System.out.print("[내용] >>");
			String content = ScanUtil.nextLine();
			
			List<Object> param = new ArrayList<>();
			
			param.add(title);
			param.add(content);
			param.add(boardno);
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			
			if(0 < noticeBoardDao.boardUpdate(param)) {
				System.out.println("수정되 었습니다.");
			}else {
				System.out.println("권한이 없습니다.");
			}
			
			return View.MY_BOARD_LIST;

		}
		
		
		
		
		
}

			
		
			

		
		


