package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		
		/*
		 * 비트연산자
		 * |,&,^,~,<<,>>
		 * 비트단위로 연산한다.
		 * 
		 * 기타연산자
		 * .(참조연산자): 특정범위 내에 속해있는 멤버를 지칭할 때 사용한다.
		 * ?:(삼항연산자): 조건식? 조건식이 참일 경우 수행할 문자:조건식이 거짓일 경우 수행할 문장
		 *  
		 *  
		*/
		
		//1byte : 01010101
		System.out.println(10|5); //2진수를 OR연산
		//10: 00001010
		//15: 00001111
		//	  00001111
		
		
		int x = 10;
		int y = 20;
		
		int result = x < y ? x : y ; //삼항연산에는 반드시 비교연산이 들어가야함. x>y 보다 작나? 참이면 int result=x 거짓이면 result=y;
		System.out.println(result);
		
		
		//주민등록번호 뒤자리의 첫번째 숫자가 1이면 남자 2이면 여자
		int regNo = 5;
		String gender = regNo == 1 ? "남자":"여자";
		System.out.println(gender);
		
		gender = regNo == 1?"남자":( regNo == 2?"여자":"확인불가"); //삼항연산자 예외처리
		System.out.println(gender);
		
		
		
		//문제: 2개의 숫자를 입력 받고, 둘중 더 큰 숫자를 출력해주세요.
		
		Scanner number = new Scanner(System.in);
//		System.out.println("첫번째 숫자");
//		int num1= Integer.parseInt(number.nextLine());
//		System.out.println("두번째 숫자");
//		int num2= Integer.parseInt(number.nextLine());
		
//		int result2 = num1 > num2 ? num1 :num2;
//		System.out.println("가장큰수는: "+result2);
		
		
		//문제: 숫자를 입력받고, 그 숫자가 1이나 3이면 남자를, 2나 4면 여자를 출력해주세요.
				//그외의 숫자를 입력하면 확인불가를 출력해주세요.
		System.out.println("숫자를 입력해주세요.");
		int num3 = Integer.parseInt(number.nextLine());
		String gender2 = num3 == 1 || num3 == 3 ?"남자":(num3 == 2 || num3 == 4 ?"여자":"확인불가");
		System.out.println("성별은 "+ gender2 +" 입니다.");
		
	
		
	}

}
