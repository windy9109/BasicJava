package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;

public class NoticeService {
	public static void main(String[] args) {
		new NoticeService().start();
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	List<Map<String, Object>> noticeList = new ArrayList<>();
	
	private void start() {
		while(true) {
			System.out.println("[공지사항 목록]___________________________________");
			String sql = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_DATE"
					+ "		FROM NOTICE";
			List<Map<String, Object>> noticeList = jdbc.selectList(sql);
			
			
			System.out.println("글번호 \t 글제목 \t 작성일");
			System.out.println("------------------------------------------");
			for(int i = noticeList.size()-1; i>=0; i--) {
				Map<String, Object> notice = noticeList.get(i);
				System.out.print(notice.get("NOTICE_NO")+"\t");
				System.out.print(notice.get("NOTICE_TITLE")+"\t");
				System.out.println(notice.get("NOTICE_DATE")+"\n");
			}
			System.out.println("______________________________________________");
			
			System.out.print("1.조회 2.등록 0.로그아웃 >>");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1: read(); break;
			case 2: insert(); break;
			case 0: break;
			}
			
		}
		
	}

	private void read() {
		System.out.println("[공지사항 조회]___________________________________");
		System.out.print("조회할 게시물 번호 >>");
		int noticeNo = ScanUtil.nextInt();
		
		String sql = "SELECT NOTICE_NO"
				+ " 	, NOTICE_TITLE"
				+ " 	, NOTICE_DATE"
				+ " 	, NOTICE_CONTENT"
				+ " 	FROM NOTICE"
				+ " 	WHERE NOTICE_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(noticeNo);
		
		Map<String, Object> notice = jdbc.selectOne(sql, param);
		
		System.out.println("번호\t: "+notice.get("NOTICE_NO"));
		System.out.println("제목\t: "+notice.get("NOTICE_TITLE"));
		System.out.println("작성일\t: "+notice.get("NOTICE_DATE"));
		System.out.println("내용\t: "+notice.get("NOTICE_CONTENT"));
		System.out.println("______________________________________________");
		System.out.print("1.수정 2.삭제 3.목록 >>");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1: update(noticeNo); break;
		case 2: delete(noticeNo); break;
		case 3: break;
		}
	}

	private void delete(int noticeNo) {
		System.out.println("[공지사항 삭제]___________________________________");
		System.out.print("정말 삭제하겠습니까? (y/n) >>");
		String yn = ScanUtil.nextLine();
		switch(yn) {
		case "y":
			String sql = "DELETE "
					+ " 	FROM NOTICE"
					+ "		WHERE NOTICE_NO = ?";
			List<Object> param = new ArrayList<>();
			param.add(noticeNo);
			
			jdbc.update(sql, param);
			System.out.println("삭제되었습니다.");
			break;
		case "n":
			System.out.println("삭제를 취소했습니다.");
			break;
		}
		
	}

	private void update(int noticeNo) {
		System.out.println("[공지사항 수정]___________________________________");
		System.out.print("[제목] >>");
		String title = ScanUtil.nextLine();
		System.out.print("[내용] >>");
		String content = ScanUtil.nextLine();
		
		String sql = "UPDATE NOTICE"
				+ " 	SET NOTICE_TITLE = ?"
				+ "			, NOTICE_CONTENT = ?"
				+ "		WHERE NOTICE_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(noticeNo);
		
		jdbc.update(sql, param);
		System.out.println("수정되었습니다.");
		
	}

	private void insert() {
		System.out.println("[공지사항 등록]___________________________________");
		System.out.print("[번호] >>");
		String number = ScanUtil.nextLine();
		System.out.print("[제목] >>");
		String title = ScanUtil.nextLine();
		System.out.print("[내용] >>");
		String content = ScanUtil.nextLine();
		
		String sql = "INSERT INTO NOTICE"
				+ "		VALUES(?,?,?,SYSDATE)";
				
		List<Object> param = new ArrayList<>();
		param.add(number);
		param.add(title);
		param.add(content);
		
		jdbc.update(sql, param);
		System.out.println("게시물이 등록되었습니다.");
	}
}
