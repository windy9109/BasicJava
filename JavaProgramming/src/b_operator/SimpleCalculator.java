package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
 
		//두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.(계산기 + - * /)
        

	      
        Scanner number = new Scanner(System.in);
        System.out.println("계산할 첫번째 숫자를 입력해주세요.");
        double num1 = number.nextDouble();
        System.out.println("연산할 사칙연산자를 입력해주세요(+, -, /, *)");
        String calculate = number.next();
        System.out.println("계산할 두번째 숫자를 입력해주세요.");
        double num2 = number.nextDouble();
        
        
        
        double result = calculate.equals("+")?num1+num2
        					:(calculate.equals("-")?num1-num2
        							:(calculate.equals("*")?num1*num2
        									:(calculate.equals("/")?num1/num2:0.0)));
        
        System.out.println("계산결과:"+(int)result);
        

	
		

	}

}




