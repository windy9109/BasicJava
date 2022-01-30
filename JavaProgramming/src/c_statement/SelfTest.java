package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		// 자가진단 테스트 10개 문항중 해당되는 문항을 출력 

		System.out.println("==============================================");
		System.out.println("           탄수화물 중독? 자가진단 해보기");
		System.out.println("==============================================");

		Scanner sc = new Scanner(System.in);

		System.out.print("1.아침을 배불리 먹은후 점심시간 전에 배가 고프다.(Y,N)  ");
		String x1 = sc.next();

		System.out.print("2.밥, 빵, 과자 등의 음식을 먹기 시작하면 끝이 없다. (Y,N)  ");
		String x2 = sc.next();

		System.out.print("3.음식을 금방 먹은 후에도 만족스럽지 못하다.(Y,N)  ");
		String x3 = sc.next();

		System.out.print("4.정말 배가 고프지 않더라도 먹을 때가 있다.(Y,N)  ");
		String x4 = sc.next();

		System.out.print("5.저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.(Y,N)  ");
		String x5 = sc.next();

		System.out.print("6.스트레스를 받으면 자꾸 먹고 싶어진다.(Y,N)  ");
		String x6 = sc.next();

		System.out.print("7.책상이나 식탁위에 항상 과자, 초콜릿 등이 놓여있다.(Y,N)  ");
		String x7 = sc.next();

		System.out.print("8.오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.(Y,N)  ");
		String x8 = sc.next();

		System.out.print("9.과자, 초콜릿 등 단 음식은 상상만 해도 먹고 싶어진다.(Y,N)  ");
		String x9 = sc.next();

		System.out.print("10.다이어트를 위해 식이조절을 하는데 3일도 못 간다.(Y,N)  ");
		String x10 = sc.next();

		int sum = 0;

		switch (x1) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x2) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x3) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x4) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x5) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x6) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x7) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x8) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x9) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		switch (x10) {
		case "y": sum++;
			break;
		case "Y": sum++;
			break;
		}
		
		

		System.out.println("==============================================");
		System.out.println("자가진단결과 총 " + sum + " 입니다.\n");

		if (sum >= 7) {
			System.out.println("(7개이상) 중독! 전문가의 상담이 필요함");
		} else if (sum >= 4 && sum <= 6) {
			System.out.println("(4~6개) 위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
		} else if (sum <= 3) {
			System.out.println("(3개) 주의! 위험한 수준은 아니지만 관리필요");
		}

		System.out.println("==============================================");
		
		
		/*
		 * String answer =null; int sum =0; System.out.println("지문"); answer =
		 * s.nextLine(); if(answer.equals(answer"Y")) { sum++; }
		 */
		

		
		
		

	}

}
