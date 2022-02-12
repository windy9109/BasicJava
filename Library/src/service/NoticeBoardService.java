package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.NoticeBoardDao;
import util.ScanUtil;
import util.View;

public class NoticeBoardService {
	private NoticeBoardService() {}
	private static NoticeBoardService instance;
	public static NoticeBoardService getInstnace() {
		if(instance == null) {
			instance= new NoticeBoardService();
		}
		return instance;
	}
	private NoticeBoardDao noticeBoardDao = NoticeBoardDao.getInstnace();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String boardno;
	
	public int noticeList() {
		System.out.println("[공지사항 목록]___________________________________");
		List<Map<String, Object>> noticeList = noticeBoardDao.noticeList();
	
		System.out.println("글번호 \t 글제목 \t 작성일");
		System.out.println("------------------------------------------");
		for(int i = noticeList.size()-1; i>=0; i--) {
			Map<String, Object> notice = noticeList.get(i);
			System.out.print(notice.get("NOTICE_NO")+"\t");
			System.out.print(notice.get("NOTICE_TITLE")+"\t");
			System.out.println(format.format(notice.get("NOTICE_DATE")));
		}
		System.out.println("______________________________________________");
		System.out.print("1.조회 0.나가기 > ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		
		case 1:
			return View.NOTICE_VIEW;
		case 0:
			if(Controller.LoginMember == null) {
				return View.HOME;
			}else {
				return View.MEMBERHOME;
			}
		}


		return View.NOTICE_LIST;
	}
	
	public int noticView() {
		System.out.println("[공지사항 조회]___________________________________");
		System.out.print("조회할 게시물 번호 >>");
		String noticeNo = ScanUtil.nextLine();
		
	
		List<Object> p = new ArrayList<>();
		p.add(noticeNo);
		
		Map<String, Object> notice = noticeBoardDao.noticeView(p);
		
		
		System.out.println("번호\t: "+notice.get("NOTICE_NO"));
		System.out.println("제목\t: "+notice.get("NOTICE_TITLE"));
		System.out.println("작성일\t: "+format.format(notice.get("NOTICE_DATE")));
		System.out.println("내용\t: "+notice.get("NOTICE_CONTENT"));
		System.out.println("______________________________________________");
		
		System.out.print("0.목록 > ");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 0:
			return View.NOTICE_LIST;
		}
		return View.NOTICE_VIEW;
	}
	
	public int boardList() {
		System.out.println("[자유게시판목록]________________________");
		List<Map<String, Object>> boardList = noticeBoardDao.boardList();
	
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("--------------------------------------");
		for(int i=boardList.size()-1; i>=0; i--) {
			Map<String, Object> board = boardList.get(i); 
			System.out.print(board.get("BOARD_NO"));
			System.out.print("\t"+board.get("BOARD_TITLE"));
			System.out.print("\t"+board.get("MEM_ID"));
			System.out.println("\t"+format.format(board.get("BOARD_DATE")));
					
		}
		System.out.println("_______________________________________");
		System.out.print("1.조회 2.등록 0.나가기 > ");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.BOARD_VIEW;
		case 2:
			return View.BOARD_INSERT;
		case 0:
			if(Controller.LoginMember == null) {
				return View.HOME;
			}else {
				return View.MEMBERHOME;
			}
		}
		
		return View.BOARD_LIST;
	}
	
	
	public int boardView() {
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
			return View.BOARD_UPATE;
		case 2:
			return View.BOARD_DELETE;
		case 0:
			return View.BOARD_LIST;
		}
		return View.BOARD_VIEW;
	}
	
	public int boardInsert() {
		
		System.out.println("[자유게시판 등록]________________________");
		System.out.print("[제목] >>");
		String title = ScanUtil.nextLine();
		System.out.print("[내용] >>");
		String content = ScanUtil.nextLine();
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(Controller.LoginMember.get("MEM_ID"));
		
		if(0 < noticeBoardDao.boardInsert(param)) {
			System.out.println("게시물이 등록되었습니다.");
		}else {
			System.out.println("등록에 실패하셨습니다.");
		}
		
		return View.BOARD_LIST;
	}
	
	public int boardDelete() {
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
		
		return View.BOARD_LIST;
	}
	
	public int boardUpdate() {
		
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
		
		return View.BOARD_LIST;

	}
	
}
