package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {


	public static void main(String[] args) {
		/*
		 * 정규표현식: 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	뒷 문자로 시작 => a^123  a뒤부터시작 
		 * $	앞 문자로 종료 => a$ a종료
		 * .	임의의 문자(줄바꿈제외)
		 * *	앞문자가 0개 이상
		 * +	앞문자가 1개이상
		 * ?	앞문자가 없거나 1개
		 * [] 문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]:a부터 z가 아닌것(부정의미))
		 * {} 앞문자의 개수({2}:2개, {2,4}:2개 이상 4개이하)
		 * () 그룹화(1개의 문자 처럼 인식)
		 * | or연산
		 * \s 공백, 탭, 줄바꿈
		 * \S 공백, 탭, 줄바꿈이 아닌 문자
		 * \w 알파벳이나 숫자 
		 * \W 알파벳이나 숫자가 아닌 문자
		 * \d 숫자
		 * \D 숫자가 아닌 문자
		 * (?i) 뒷문자의 대소문자 구분 안함
		 * \ 정규표현식에서 사용되는 특수문자 표현 => 정규표현식 앞에 넣어주면 원래의 문자를 볼수있다.
		 * 
		 * 
		*/
		
		
		//정규표현식 만들기
		String str = "abc123";
//		String regex = "[a-z]";  // a~z까지 중 한글자라는 뜻
//		String regex2 = "[a-z]{3}";  // a~z까지중 정확히 3글자가 와야함
//		String regex3 = "[a-z]{3}[0-9]{1,3}"; // a~z까지중 정확히 3글자가 와야함, 0~9까지증 1개이상 3개이하의 글자
//		String regex4 = "[a-z]{3}[0-9]{1,}"; // a~z까지중 정확히 3글자가 와야함, 0~9까지증 1개이상의 글자
//		String regex5 = "[a-z0-9]+"; //알파벳이어도 되고 숫자여도 됨, 1개이상
		String regex6 = "\\w*";	//알파벳이나 숫자 
		// "\\w*" => 역슬래시는 탈출문자로 사용되기때문에 앞에 추가로 써줘야함. 자바에서는 역슬래시 두개가 하나임
		
		
//		Pattern p = Pattern.compile(regex6);
//		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
		
		
		
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		/*
		 * 
		 * ex)아이디는 5~20자의 영문 소문자, 숫자와 특수기호 (_),(-)만 사용가능합니다.
		 * 
		 * 아이디: [a-z0-9_-]{5,20}  
		 * 전화번호: ^0\\d{1,3}-\\{3,4}-\\d{4}
		 * 이메일주소: [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z{2}\\.kr]))$
		 * 
		*/
		
		String ID = "[a-z0-9\\_*\\-*]{5,20}";
		String tell = "^010-[0-9]{4}\\-{1}[0-9]{4}";
		String email = "[A-Za-z0-9]+\\@[A-Za-z]{1,}\\.[A-Za-z]+";
		
		
	
		
		String IDtest = "windy000_0";
		String telltest = "010-4868-1307";
		String emailtest = "windy0000@naver.com";
		
		Pattern ID1 = Pattern.compile(ID);
		Matcher ID2 = ID1.matcher(IDtest);
		System.out.println(ID2.matches());
		
		Pattern tell1 = Pattern.compile(tell);
		Matcher tell2 = tell1.matcher(telltest);
		System.out.println(tell2.matches());
		
		
		Pattern email1 = Pattern.compile(email);
		Matcher email2 = email1.matcher(emailtest);
		System.out.println(email2.matches());
		

		
		
	}

}







