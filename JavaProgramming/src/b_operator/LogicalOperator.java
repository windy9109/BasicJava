package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리연산자 
		 * &&(AND), ||(OR), !(NOT)
		 * 피연산자로 boolean만 허용한다.
		 * 
		*/
		
		int x = 10;
		int y = 20;
		
		boolean b = 0 < x && x < 10 || x < y; //비교연산이 논리연산보다 우선순위가 높다.
		//and연산이 or보다 먼저 실행된다.
		
		b = !(x<y); //조건식의 결과를 반대로 저장한다.
		//비교연산의 not인 경우 괄호로 연산을 감싸준뒤 !를 붙인다.
		
		
		//논리연산은 효율적연산을 한다.
		b= true && true; //true
		b= true && false; //false
		b= false && true; //false
		b= false && false; //false
		
		b= true || true; //true
		b= true || false; //true
		b= false || true; //true
		b= false || false; //false
		
		int a = 10;
		b = a < 5 && 0 < a++; // a < 5가 false 이므로 우항의 a++은 실행되지 않고 10값이 그대로 내려온다.
		System.out.println(a);
		
		
		//다음의 문장들을 코드로 작성해주세요.
		//1. Q가 W보다 크고 Q가 10보다 작다.
		//2. Q가 짝수이고 W보다 작거나 같다.
		//3. Q가 3의 배수이거나 5의 배수이다.
		
		/* boolean C; */
		
//		c = Q > W && Q < 10;
//		c = Q % 2 == 0 && Q <= W;
//		c = Q % 3 == 0 || Q % 5 == 0;
		
		
		
	}

}
