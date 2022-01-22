package e_oop;

public class Calculator {
	
	/*
	 * 계산기만들기  
	 * 산술연산자 +, -, *, /, % 를 할수있는 다섯개의 메서드 만들기
	 * 파라미터와 리턴값정하기
	 *계산에 필요한값: 파라미터로 받기
	 *연산후 값: 리턴으로 돌려주기  
	*/


	double plus(double a, double b) {
		return a+b;
	}
	double subtract(double a, double b) {
		return a-b;
	}
	
	double multiply(double a, double b) {
		return a*b;
	}
	
	double divide(double a, double b) {
		return a/b;
	}
	double share(double a, double b) {
		return a%b;
	}
	
	

	public static void main(String[] args) {

		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
		
		Calculator sc = new Calculator();
		double A = sc.plus(123456,654321);
		double B = sc.multiply(A,123456);
		System.out.printf("%d",(int)B);
		System.out.println();
		System.out.printf("%f",B);//실수타입으로 출력
		double C = sc.divide(B,123456);
		double D = sc.subtract(C,654321);
		double E = sc.share(D,123456);
		
		System.out.println();
		
		System.out.println("1: "+A);
		System.out.println("2: "+B);
		System.out.println("3: "+C);
		System.out.println("4: "+D);
		System.out.println("5: "+E);
		
		

		
		
	}

}
