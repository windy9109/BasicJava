package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * <, >, <=, >=, ==, !=
		 * 문자열비교: equals()
		 * ※비교연산자는 주소를 비교함.
		 * 
		*/
		
		int x =10;
		int y =20;
		boolean b = x < y;
		System.out.println(b);
		b = x <= y - 15; //우선순위는 산술연산이 비교연산 보다 더 높다.
		
		String str1 = "abc";
		String str2 = "ABC";
		
		b = str1 == str2; //내용비교X, 주소비교O -> 내용을 비교하는게 아니라 같은 주소값인지를 비교하는 것이므로 오류가 날수 있음. 따라서 .equals로 비교한다
		System.out.println(b);
		
		b = str1.equals(str2); //.equals로 비교
		System.out.println(b);
		
		b = !str1.equals(str2); //! .equals로 not 비교
		System.out.println(b);
		
		//다음의 문장들을 코드로 작성해주세요.
		//a1는 b1보다 작거나 같다.
		//a1+5와 b1는 같다.
		//b1는 홀수이다.
		//"기본형"과 "참조형"은 다르다.
		
		int a1=4;
		int b1=9;
		boolean z1 = a1 >= b1;
		boolean z2 = a1 + 5 == b1;
		boolean z3 = b1 % 2 == 1;
				
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		
		
				
		
		
		
		
		
	}

}
