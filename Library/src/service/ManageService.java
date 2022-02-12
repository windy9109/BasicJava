package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import dao.ManagerDao;
import util.ScanUtil;
import util.View;

public class ManageService {
	private ManageService() {
	}

	private static ManageService instance;

	public static ManageService getInstnace() {
		if (instance == null) {
			instance = new ManageService();
		}
		return instance;
	}

	public int login() {
		return 0;
	}

	ManagerDao managerDao = ManagerDao.getInstnace();

	// ================관리자 도서 관리 화면=================
	public int bookListM() {
		bookListView();
		System.out.println("[도서 관리]________________________________________________");

		System.out.print("1.도서등록 2.도서 정보수정 3.도서 정보삭제 4.리뷰조회 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			bookEnroll();
			break;
		case 2:
			modifyBook();
			break;
		case 3:
			deleteBook();
			break;
		case 4:
			return View.REVIEW_CHECK_M;
		case 0:
			return View.MANAGE_HOME;
		}

		return View.BOOK_LIST_M;
	}
	// 도서관리 메서드

	// 도서 등록
	private int bookEnroll() {
		System.out.println("책 이름>");
		String title = ScanUtil.nextLine();
		System.out.println("저자>");
		String writer = ScanUtil.nextLine();
		System.out.println("출판사>");
		String pub = ScanUtil.nextLine();
		System.out.println("수량>");
		int qty = ScanUtil.nextInt();
		System.out.println("철학 종교 예술 언어 문학 역사 과학\n선택하여 넣으시오");
		System.out.println("책 분류명>");
		String kind = ScanUtil.nextLine();
		if (kind.equals("철학")) {
			kind = "100";
		} else if (kind.equals("종교")) {
			kind = "200";
		} else if (kind.equals("예술")) {
			kind = "300";
		} else if (kind.equals("언어")) {
			kind = "400";
		} else if (kind.equals("문학")) {
			kind = "500";
		} else if (kind.equals("역사")) {
			kind = "600";
		} else if (kind.equals("과학")) {
			kind = "700";
		} else {
			System.out.println("관련된 분류명이 없습니다.");
			return View.BOOK_LIST_M;
		}

		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(writer);
		param.add(pub);
		param.add(qty);
		param.add(kind);

		int result = managerDao.insertBook(param);
		if (result == 0) {
			System.out.println("등록에 실패했습니다.");
			return View.BOOK_LIST_M;
		} else {
			System.out.println("등록에 성공했습니다.");
			return View.BOOK_LIST_M;
		}

	}

	// 도서 정보 수정
	private int modifyBook() {
		List<Object> param = new ArrayList<>();
		System.out.print("수정 할 도서 번호 입력>");
		int bookNo = ScanUtil.nextInt();
		param.add(bookNo);
		int result = managerDao.modifyBook(param);
		if (result == 0) {
			System.out.println("수정에 실패했습니다.");
		} else {
			System.out.println("수정에 성공했습니다.");
		}
		return View.BOOK_LIST_M;
	}

	// 도서 삭제
	private int deleteBook() {
		List<Object> param = new ArrayList<>();
		System.out.print("삭제 할 도서 번호 입력>");
		int bookNo = ScanUtil.nextInt();
		param.add(bookNo);
		int result = managerDao.deleteBook(param);
		if (result == 0) {
			System.out.println("수정에 성공했습니다.");
		} else {
			System.out.println("수정에 실패했습니다.");
		}
		return View.BOOK_LIST_M;
	}

	public void bookListView() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, Object>> bookList = managerDao.bookListView();
		Map<String, Object> book = null;
		System.out.println("[도서 목록]_________________________________________________________");
		System.out.println("책번호\t책이름\t저자\t출판사\t수량\t종류\t날짜\t별점");
		for (int i = 0; i < bookList.size(); i++) {
			book = bookList.get(i);
			System.out.print(book.get("BOOK_ID") + "\t");
			System.out.print(book.get("NAME") + "\t");
			System.out.print(book.get("WRITER") + "\t");
			System.out.print(book.get("PUB") + "\t");
			System.out.print(book.get("BOOK_QTY") + "\t");
			System.out.print(book.get("KIND") + "\t");
			System.out.println(format.format(book.get("BOOK_DATE")) + "\t");
			
		}

	}

	// 예약관리 화면
	public int reservView() {
		SimpleDateFormat format = new SimpleDateFormat("YY-MM-dd");
		List<Map<String, Object>> reservList = managerDao.reservListView();
		Map<String, Object> reserv = null;
		System.out.println("[예약 확인]___________________________________________________________");
		System.out.printf("%s%13s%14s%13s%13s", "예약번호", "예약날짜", "회원번호", "책번호", "대출가능여부");
		System.out.println();
		for (int i = 0; i < reservList.size(); i++) {
			reserv = reservList.get(i);
			System.out.print(reserv.get("RES_ID") + "\t");
			System.out.print(format.format(reserv.get("RES_DATE")) + "\t");
			System.out.print(reserv.get("MEM_ID") + "\t");
			System.out.print(reserv.get("BOOK_ID") + "\t");
			System.out.print(reserv.get("RENT"));
			System.out.println();
		}
		System.out.println();
		System.out.printf("%10s%10s", "1.예약승인", "2.예약거절 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			reservApv();
			break;
		case 2:
			reservRefuse();
			break;
		case 0:
			return View.MANAGE_HOME;

		}
		return View.RESERV_LIST_M;
	}

	// 예약 승인
	public int reservApv() {
		System.out.print("예약 번호를 입력하세요 >");
		int reservNo = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		param.add(reservNo);
		
		try {
		Map<String, Object> p = managerDao.loanCount(param);
		
		List<Object> pa = new ArrayList<>();
		pa.add(p.get("MEM_ID"));
		
		managerDao.loanCountM(pa);

		if(0 < Integer.parseInt(String.valueOf(p.get("MEM_LCN")))) {
			managerDao.loanInsert(param);
			int result = managerDao.dreservAPV(param);
			int result2 = managerDao.reservAPV(param);
			
			if (result == 0 && result2 == 0) {
				System.out.println("예약 승인 처리에 실패했습니다.");
				return View.RESERV_LIST_M;
			} else {
				System.out.println("예약이 승인되었습니다.");
				return View.RESERV_LIST_M;
			}

		}else {
			System.out.println("더이상 대출 승인을 할 수 없습니다.");
			return View.RESERV_LIST_M;
			
		}
		
		}catch (Exception e) {
			
			System.out.println("더이상 대출 승인을 할 수 없습니다.");
			return View.RESERV_LIST_M;
		}
	}

	// 예약거절
	public int reservRefuse() {
		System.out.print("예약 번호를 입력하세요 >");
		int reservNo = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		param.add(reservNo);
		
		Map<String, Object> p = managerDao.loanCount(param);
		
		List<Object> pa = new ArrayList<>();
		pa.add(p.get("MEM_ID"));
		
		managerDao.loanCountP(pa);
		
		
		int result = managerDao.dreservAPV(param);
		int result2 = managerDao.reservAPV(param);
		
		
		if (result == 0 && result2 == 0) {
			System.out.println("예약 거절이 수행되지 않았습니다");
			return View.RESERV_LIST_M;
		} else {
			System.out.println("예약을 거절 하였습니다.");
			return View.RESERV_LIST_M;
		}
	}

	public int loanView() {
		System.out.println("[대출 확인]________________________________________________");
		System.out.print("1.대출현황 2.미납자조회 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			loanListView();
			break;
		case 2:
			getDefaulterList();
			break;
		case 0:
			return View.MANAGE_HOME;
		}
		return View.BOOK_RENT_M;
	}

	public int loanListView() {
		SimpleDateFormat format = new SimpleDateFormat("YY-MM-dd");
		System.out.println("[대출 목록]_________________________________________________________________________________________");
		System.out.printf("%s%14s%20s%20s%18s%20s%18s%18s", "대출번호", "대출날짜", "반납기한", "책번호", "책이름", "회원아이디", "회원명",
				"대출상태");
		System.out.println();
		List<Map<String, Object>> loanList = managerDao.loanListViewD();
		for (int i = 0; i < loanList.size(); i++) {
			Map<String, Object> loanMap = loanList.get(i);
			System.out.printf("%2s", loanMap.get("LOANID"));
			System.out.printf("%14s", format.format(loanMap.get("LOANDATE")));
			System.out.printf("%14s", format.format(loanMap.get("DUE")));
			System.out.printf("%10s", loanMap.get("BOOKID"));
			System.out.printf("%14s", loanMap.get("BNAME"));
			System.out.printf("%12s", loanMap.get("MEMID"));
			System.out.printf("%12s", loanMap.get("MNAME"));
			System.out.printf("%12s", loanMap.get("CH"));
			System.out.println();
		}
		System.out.print("1.반납확인 0.나가기  > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.print("반납이 확인된 대출번호를 입력하세요>");
			int input2 = ScanUtil.nextInt();
			List<Object> param = new ArrayList<>();
			param.add(input2);
			int result2 = managerDao.bookReturnCheck(param);
			if (result2 == 0) {
				System.out.println("대출번호를 다시 입력해주세요");
				return View.BOOK_RENT_M;
			} else {
				System.out.println("정상적으로 처리되었습니다.");
				return View.BOOK_RENT_M;
			}
		case 0:
			return View.BOOK_RENT_M;

		}
		return View.BOOK_RENT_M;
	}

	public int getDefaulterList() {
		int result = managerDao.updateDefaulter();
		System.out.println(result + "명의 미납자가 추가 되었습니다");
		List<Map<String, Object>> defaulterList = managerDao.defaulterList();
		System.out.println("[미납자 목록]__________________________________________________________________");
		System.out.printf("%s%12s%15s%15s%15s%15s", "대출번호", "책번호", "책이름", "회원번호", "회원명", "전화번호");
		System.out.println();
		for (int i = 0; i < defaulterList.size(); i++) {
			Map<String, Object> map = defaulterList.get(i);
			System.out.printf("%s", map.get("LOANID"));
			System.out.printf("%10s", map.get("BOOKID"));
			System.out.printf("%14s", map.get("BNAME"));
			System.out.printf("%7s", map.get("MEMID"));
			System.out.printf("%9s", map.get("MNAME"));
			System.out.printf("%9s", map.get("PHONE"));
			System.out.println();
		}
		return View.BOOK_RENT_M;
	}

	public int FboardListM() {
		SimpleDateFormat format = new SimpleDateFormat("YY-MM-dd");
		List<Map<String, Object>> boardList = managerDao.boardListViewM();
		System.out.println("[자유게시판]___________________________________");
		System.out.println("게시물번호\t제목\t작성날짜\t회원ID");
		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> map = boardList.get(i);
			System.out.print(map.get("BOARD_NO") + "\t");
			System.out.print(map.get("BOARD_TITLE") + "\t");
			System.out.print(format.format(map.get("BOARD_DATE")) + "\t");
			System.out.print(map.get("MEM_ID") + "\t");
			System.out.println();
		}
		System.out.print("1.게시물 조회 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			return View.F_BOARD_CONTENT_M;
		case 0:
			return View.MANAGE_HOME;
		}

		return 0;
	}

	public int getContent() {
		System.out.println("조회할 게시물 번호를 입력하세요");
		int input = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		param.add(input);
		Map<String, Object> map = managerDao.getBoard(param);
		System.out.println("[자유게시판]___________________________________");
		System.out.println("제목: " + map.get("BOARD_TITLE"));
		System.out.println("내용: " + map.get("BOARD_CONTENT"));
		System.out.println("등록날짜: " + map.get("BOARD_DATE"));
		System.out.println("작성자: " + map.get("MEM_ID"));
		System.out.print("1.삭제 0.나가기 > ");
		int input2 = ScanUtil.nextInt();
		switch (input2) {
		case 1:
			int result = managerDao.boardDelete(param);
			if(result == 0) {
				System.out.println("삭제 실패");
			}else {
				System.out.println("삭제 성공");
			}
			return View.BOARD_LIST_M;
		case 0:
			return View.BOARD_LIST_M;

		}
		return View.BOARD_LIST_M;
	}

	public int boardViewM() {
		System.out.print("1.자유게시판 2.공지사항 게시판 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			return View.F_BOARD_M;
		case 2:
			return View.NOTICE_BOARD_M;
		case 0:
			return View.BOARD_LIST_M;
		}
		return View.BOARD_LIST_M;
	}

	public int noticeBoardView() {
		SimpleDateFormat format = new SimpleDateFormat("YY-MM-dd");
		System.out.println("[공지사항 목록]___________________________________");
		List<Map<String, Object>> noticeList = managerDao.noticeBoardDaoM();
		System.out.println("글번호 \t 글제목 \t 작성일");
		System.out.println("------------------------------------------");
		for (int i = noticeList.size() - 1; i >= 0; i--) {
			Map<String, Object> notice = noticeList.get(i);
			System.out.print(notice.get("NOTICE_NO") + "\t");
			System.out.print(notice.get("NOTICE_TITLE") + "\t");
			System.out.println(format.format(notice.get("NOTICE_DATE")));
		}
		System.out.println("______________________________________________");
		System.out.print("1.조회 0.나가기 > ");
		int input = ScanUtil.nextInt();

		switch (input) {

		case 1:
			return View.NOTICE_VIEW_M;
		case 0:
			return View.BOARD_LIST_M;
		}
		return View.BOARD_LIST_M;
	}
	
	public int noticeManage() {
		System.out.println("[공지사항 조회]___________________________________");
		System.out.print("조회할 게시물 번호 >>");
		int input = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		param.add(input);
		Map<String, Object> notice = managerDao.noticeCheck(param);
		System.out.println("공지사항 번호: "+notice.get("NOTICE_NO"));
		System.out.println("제목: "+notice.get("NOTICE_TITLE"));
		System.out.println("내용: "+notice.get("NOTICE_CONTENT"));
		System.out.println("작성날짜: "+notice.get("NOTICE_DATE"));
		System.out.println("______________________________________________");
		System.out.print("1.수정 2.삭제 0.나가기 > ");
		int input2 = ScanUtil.nextInt();
		switch(input2) {
		case 1:
			int result = managerDao.noticeModify(param);
			if(result == 0) {
				System.out.println("수정 실패했습니다");
			}else {
				System.out.println("수정 성공했습니다");
			}
			return View.NOTICE_BOARD_M;
		case 2:
			int result2 = managerDao.noticeDelete(param);
			if(result2 == 0) {
				System.out.println("삭제 실패했습니다");
			}else {
				System.out.println("삭제 성공했습니다");
			}
			return View.NOTICE_BOARD_M;
		case 0:
			return View.NOTICE_BOARD_M;
		}
		
		return View.NOTICE_BOARD_M;
		
	}
	
	public int noticeRegist() {
		System.out.print("제목을 입력하세요>");
		String intitle = ScanUtil.nextLine();
		System.out.print("내용을 입력하세요>");
		String incontent = ScanUtil.nextLine();
		List<Object> param = new ArrayList<>();
		param.add(intitle);
		param.add(incontent);
		int result = managerDao.noticeRegistDao(param);
		if(result == 0) {
			System.out.println("게시물이 정상적으로 등록됐습니다.");
		}else {
			System.out.println("게시물 등록에 실패했습니다.");
		}
		
		return View.NOTICE_BOARD_M;
	}
	
	public int MreviewCheck() {
		List<Map<String, Object>> reCh = managerDao.reviewCheck();
		System.out.println("[리뷰 목록]___________________________________");
		System.out.println("리뷰번호\t책번호\t리뷰내용\t별점");
		for(int i = 0; i < reCh.size(); i++) {
			System.out.print(reCh.get(i).get("REVIEW_NO")+"\t");
			System.out.print(reCh.get(i).get("BOOK_ID")+"\t");
			System.out.print(reCh.get(i).get("CONTENT")+"\t");
			System.out.println(reCh.get(i).get("REVIEW_STAR")+"\t");
		}
		System.out.println("__________________________________________");
		System.out.print("1.조회 0.나가기>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			return View.REVIEW_INFO_M;
		case 0:
			return View.BOOK_LIST_M;

		}
		return View.BOOK_LIST_M;
	}
	
	public int MreviewInfo() {
		System.out.print("조회 할 리뷰 번호를 입력하세요>");
		int input = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		param.add(input);
		Map<String, Object> reInfo = managerDao.reviewInfo(param);
		System.out.println("[리뷰 상세]___________________________________");
		System.out.println("책번호: "+reInfo.get("BOOK_ID"));
		System.out.println("책이름: "+reInfo.get("BOOK_NAME"));
		System.out.println("리뷰내용: "+reInfo.get("REVIEW_CONTENT"));
		System.out.println("별점: "+reInfo.get("REVIEW_STAR"));
		System.out.print("0.나가기>");
		int input2 = ScanUtil.nextInt();
		switch(input2){
		case 0: 
			return View.REVIEW_CHECK_M;
		}
		
		return View.REVIEW_CHECK_M;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
