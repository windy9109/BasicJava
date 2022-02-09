package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDao;
import util.ScanUtil;

public class MemberService {
	
	
	private MemberService() {
		
	}
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	public static Map<String, Object> LoginMember;
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	public int join() {
		System.out.println("---------- 회원가입 ----------");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.println("이름>");
		String memName = ScanUtil.nextLine();
		
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MEM_ID",memId);
		param.put("PASSWORD", password);
		param.put("MEM_NAME", memName);
		
		int result = memberDao.insertMember(param);
		
		if(0< result) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
		
	}
	
	
	public int login() {
		System.out.println("===============로그인===============");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
	}
	
	
	Map<String, Object> member = memberDao.selectMember(memId, password);
	if(member == null) {
		System.out.println("아이디혹은 비밀번호를 잘못 입력하셨습니다.");
	}else {
		System.out.println("로그인성공");
		LoginMember = member;
		return View.BOARD_LIST;
		
	}
	return View.LOGIN;

}













