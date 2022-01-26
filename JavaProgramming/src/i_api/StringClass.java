package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - 여러개의 문자를 사용하기 쉽게 만들어놓은 클래스
		 * 
		 * String의 주요메서드
		 * - equals(): 문자열의 내용이 같은지 반환한다.
		 * - length(): 문자열의 길이를 반환한다
		 * - charAt(): 특정 인덱스에 위치한 문자를 반환한다
		 * - substring(): 문자열의 특정 부분을 잘라서 반환한다
		 * - indexOf(): 문자열내의 특정 문자의 인덱스를 반환한다
		 * - contains(): 문자열이 특정문자열을 포함하고있는지 여부를 반환한다.
		 * - split(): 문자열를 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 * - replace(): 문자열 내의 특정문자를 다른 문자로 바꿔서 반환한다.
		 * - trim(): 문자열 앞뒤의 공백을 제거해 반환한다.
		 * - valueoOf(): 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 * 
		 * 
		*/
		
		
		String str = "12345";
//		int length = str.length();		
//		for(int i=0; i< length; i++) {
//			char charAt = str.charAt(i);
//			System.out.println(charAt);
//		}
		
		
		//문자열뒤집기
		String rev = "";
		for(int i=str.length()-1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev+"문자열뒤집기");
		
		
		
		
		//갈라져서 반환
//		str = "0123456789";
//		String sub1 =str.substring(3);
//		System.out.println(sub1);
		
		
		
		//갈라져서 반환
//		str = "0123456789";
//		String sub1 =str.substring(3);
//		System.out.println(sub1);
//		String sub2 =str.substring(5,8); // 자를때 끝나는 인덱스 전까지만 반환. 따라서 5,6,7만 반환함
//		System.out.println(sub2);
		
		
		
		//해당하는 문자열이 몇번에 있는지 찾아줌
		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지");
		System.out.println(index);
		//찾고자 하는 내용이 없을떄 -1이 반환
		
		
		
		//substring와 indexOf를 조합해서 문자열 자르기
		String[]menu = {
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원"
		};
		
		
		for(int i=0; i< menu.length; i++) {
			String name = menu[i].substring(0, menu[i].indexOf(" ")); //" "안의 공백 있는 부분까지 자른다.
			System.out.println(name);
		}
		
		
		//가격만 int타입의 변수에 저장한다.
		for(int i=0; i< menu.length; i++) {
			String money = menu[i].substring(menu[i].indexOf(" ")+1,menu[i].indexOf("원"));
			//System.out.println(money);
			int intMoney = Integer.parseInt(money); //int형으로 변환
			System.out.println(intMoney);
		}
		
		
		//해당문자(/)를 없애고 배열에 담긴다.
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));

		
		//메뉴명과 가격나누기
		for(int i=0; i<menu.length; i++) {
			String[] split2 = menu[i].split(" ");
			System.out.println(split2[0]+":"+split2[1]); //split로 순서대로 들어가게함
		}
		
		//특정문자을 지정하여 원하는 문자로 변경
		str = "123123123";
		str = str.replace("3","짝");
		System.out.println(str);
		
		
		//trim은 문자열 앞뒤의 공백을 제거해줌(문자열 사이의 공백은 제거 안함)
		str = "   문 자 열   ";
		String trim = str.trim();
		System.out.println("["+str+"] -> ["+trim+"]");
		
		
		//String 타입으로 바꾸는 방법1(편법)
		int num = 10;
		str = num +""; 
		
		//String 타입으로 바꾸는 방법1(정공)
		int num2 = 10;
		str = String.valueOf(num2);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	


}
