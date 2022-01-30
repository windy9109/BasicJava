package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 
		 * 조건문 
		 * -if문
		 * -switch문
		 * 
		 * if문
		 * -if(조건식){}: 조건식의 결과가 ture 이면 블럭안의 문장을 수행한다.
		 * -else if(조건식){}: 다수의 조건이 필요할때 if뒤에 추가한다.
		 * -else{}: 조건식 이외의 경우를 위해 추가한다.
		 * 
		 * 
		*/
		
		
		//if
//		int a = 1;
//		if( a == 1 ) {
//			System.out.println("조건식의 연산결과가 true이면 수행된다.");
//		}
		
		
		
		//else if
		int a = 2;
		
		if(a==1) {
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		if(a==1) {
			System.out.println("a==1");
		}else if(a==2) {
			System.out.println("a==2");
		}else if(a==3) {
			System.out.println("a==3");
		}else {
			System.out.println("else");
		}
		
		
		
		//문제: 점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 80;
		if(score>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		
		//점수에 등급을 부여
		score =90;
		String grade = null;
		//기본값: 자동으로 저장되는 값(데이터 기본값:0, 참조형 기본값:unll)
		//boolean 기본값: false
		
		if(score>=90 && score<=100) {
			grade="A학점";
		}else if(score>=80){
			grade="B학점";
		}else if(score>=70){
			grade="C학점";
		}else if(score>=60){
			grade="D학점";
		}else {
			grade="재수강";
		}
		
		System.out.println("해당 과목은 "+score+"점 "+grade+" 입니다.");
		
		
		
		// 학점프로그램2
		score = 68;
		grade = null;
		if (90 <= score && score <= 100) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}

		System.out.println("해당 과목은 " + score + "점 " + grade + " 입니다.");
		
		//정렬: ctrl + shift + f
		
		
		
		/*
		 * switch문
		 * -swith(int/String){ case1: break; }
		 * -조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용/이전버전은 int만 허용)허용한다.
		 * -조건식을 일치하는 case문 이후의 문장을 수행한다.
		*/
		
		a = 40;
		switch(a){
		case 10:
			System.out.println("a==10");
			break;
		case 20:
			System.out.println("a==20");
			break;
		default:
			System.out.println("default"); //선행조건들이 모두 만족하지 않을시 실행
		}
		
		
		//월에 해당하는 계절을 출력
		int month = 12;
		String season = null;
		
		switch(month) {
		case 3,4,5:
			season = "봄";
			break;
		case 6,7,8:
			season = "여름";
			break;
		case 9,10,11:
			season = "가을";
			break;
		case 12,1,2:
			season = "겨울";
			break;

		}
		System.out.println(month+"월: "+season);
		
		
		
		
		score = 68;
		grade = null;
		switch(score/10) {
		case 9,10:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		
		System.out.println(score+"점: "+grade);
		
		
		
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자를 입력해주세요.");
//		int num1 = Integer.parseInt(sc.nextLine());
		
		
//		switch(num1%2){
//			case 0:
//				System.out.println("짝수");
//				break;
//			case 1:
//				System.out.println("홀수");
//				break;
				
//		}
		
		
		
		//if의 경우
		
//		if(num1%2 == 1) {
//			System.out.println("홀수");
//		}else {
//			System.out.println("짝수");
//		}
		
		
		//1~100사이의 랜덤한 값을 3개 발생시키고 합계, 평균, 등급을 출력해주세요.
		
		int random1 = (int)(Math.random()*100)+1;
		int random2 = (int)(Math.random()*100)+1;
		int random3 = (int)(Math.random()*100)+1;
		
		int sum = random1+random2+random3;
		double age = Math.round(sum/3.0*10)/10.0;
		
		String reult;
		
		if(90<=age && age<=100) {
			reult="A";
		}else if(80<=age){
			reult="B";
		}else if(70<=age){
			reult="C";
		}else if(60<=age){
			reult="D";
		}else {
			reult="F";
		}
		

		
		System.out.println("합계: "+ sum);
		System.out.println("평균: "+ age);
		System.out.println("등급: "+ reult);
		
		
		
		//문제: 1~100사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력해주세요.
		
		int number1 = (int)(Math.random()*100)+1;
		int number2 = (int)(Math.random()*100)+1;
		int number3 = (int)(Math.random()*100)+1;
		
		int temp;
		
		if(number1>number2) {
			temp=number1;
			number1=number2;
			number2=temp;
			}
		if(number1>number3) {
			temp=number1;
			number1=number3;
			number3=temp;
		}
		if(number2>number3) {
			temp=number2;
			number2=number3;
			number3=temp;
			}

		
		System.out.println(number1+"<"+number2+"<"+number3);
		
		
		//
		
		
	
		
		
		
		
	}

}
