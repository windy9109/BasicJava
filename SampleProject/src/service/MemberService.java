package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDao;
import util.ScanUtil;
import util.View;

public class MemberService {

	//싱글톤패턴: 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MemberService() {
		
	}
	
	private static MemberService instance; //객체를 보관할 변수
	public static MemberService getInstance() {
		if(instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	
	public static Map<String, Object>LoginMember;
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	public static int join() {
		System.out.println("================== 회원가입 ==================");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.println("이름>");
		String memName = ScanUtil.nextLine();
		//아이디 중복확인
		//비밀번호 확인
		//유효성검사(정규표현식)
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ME_ID", memId);
		param.put("PASSWORD", password);
		param.put("MEM_NAME", memName);
		
		int result = memberDao.insertMember(param);
		//재사용을 용이하게 하기위하여
		if(0< result) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("회원가입실패");
		}
		
		return View.HOME;

	}

	public static int login() {
		System.out.println("===================로그인");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
		Map<String, Object> member = memberDao.selectMember(memId, password);
		
		if(member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력 하셨습니다.");
		}else {
			System.out.println("로그인성공");
			LoginMember = member;
			return View.BOARD_LIST;
		}
		return View.LOGIN;
	}
	
	
}








