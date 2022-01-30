package a_variable; //패키지: 클래스의 위치

import java.util.Scanner;

public class Variable { //클래스: 자바프로그램의 구성요소(데이터)
	

	byte x1= 0;
	short x2= 2;
	int x3=10;
	long x4=1000L;
	float x5=5.10f;
	double x6= 22.222;
	char x7='나';
	boolean x8= false;
	String x9 ="안녕하세요";
	
	/* 기본형 타입
	 * -정수: byte(1), short(2), *int(4/약20억), long(8)
	 * -실수: float(4/7자리), *double(8/15자리)
	 * -문자: char(2) -> 한글자만 표현가능 / 작음따옴표
	 * -논리: boolean(1)
	 * 
	 * 참조형 타입 
	 * -문자열: String(4) -> 여러문자 표현가능 / 큰따옴표
	 * 
	 * 명명규칙
	 * -영문자 대소문자, 한글, 숫자, 특수문자(_,$)를 사용할 수 있다.
	 * -숫자로 시작할 수 없다.
	 * -예약어는 사용할 수 없다.
	 * -[낙타식 표기법을 사용한다.(mySampleVariable)] -> 소문자로
	 * -[클래스명의 첫글자는 대문자로 한다(MySampleClass)] -> 클래스만 대문자로
	 *  
	 */ 

	
	public static void main(String[] args) { //메서드:명령문의 집합
		//주석: 프로그램 코드로 인식하지 않는 문장(주로 코드르 설명하는데 사용)
		
//		한줄주석: ctrl + shift + c
//		한줄주석: ctrl + shift + c
//		한줄주석: ctrl + shift + c
//		한줄주석: ctrl + shift + c
		
		/* 범위주석: ctrl + shift + / (해제:ctrl + shift + \) */
		
		int x=10; //변수선언
		long a= 30L; //long타입은 접미사 L을 붙여준다. L을 붙여야 long 타입이 된다. 접미사는 대문자로 사용한다. 작은숫자보다 큰숫자에 사용
		float b = 3.14f; //접미사 f를 붙여야 float타입이 된다.
		char c = '가'; //char문자 사용하기 위해서는 작은따옴표를 사용하고 반드시 한글자만 넣는다. 
		boolean d = true; //ture, false 둘중하나만 저장가능
		String e ="가나다라"; //아무글자도 안들어갈수있고 여러글자도 들어갈 수 있다. 
		
		
		//9가지 타입을 모두 사용해 9개의 변수를 선언 및 초기화 해주세요.
		
		
		
		
		//형변환(데이터의 타입을 다른 타입으로 변경하는 것)
		int _int=10;
		long _long=20L;
		
		_int =(int)_long; //형변환시 () 괄호안에 변환원하는 자료형 저장, 명시적 형변환 (데이터손실 가능성 있음)
		_long = _int; //묵시적 형변환, 표현범위가 작은타입에서 큰타입으로의 형변환은 생략가능.
		
		
		//변수 3개를 선언해 변수의 타입과 다른 타입의 값으로 초기화 해주세요.
		int y1 = 10;
		float y2 = 3.5f;
		long y3 = 100L;
		char y4='다';
		
		y1=(int)y2;
		y2=y3;
		y3=(long)y2;
		y3=(long)y1;
		
		
		y4=(char)y1;
		y1=y4;
		//기본형 타입과 참조형 타입간에는 형변환 불가능
		//유니코드표 참고

		
		//출력(콘솔)
		System.out.print("출력\n");//print 출력문 안의 소괄호는 무조건 메소드
		System.out.println("출력 후 줄바꿈"); //줄바꿈
		System.out.printf("출력 포멧 지정\n"); //
		//실행 단축키 : ctrl + f11 (실행하기 전 저장하기)
	
		//탈출 문자
		System.out.println("탭은 \t4칸에 맞춰 띄워줍니다."); // \t -> tap
		System.out.println("줄바꿈을 \n해줍니다.");
		System.out.println("\"쌍따옴표를 넣어줍니다.\"");
		System.out.println("\\역슬래시를 넣어줍니다.");
		
		//입력
//		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스, 메소드가 다른패키지에 있을 경우 import로 명시해줘야함
		
		  //import 자동화 단축키: ctrl + shift + o ※중요!!!
//		  System.out.println("아무 문자열이나 입력해주세요>"); //입력받은 메소드를
//		  String str=sc.nextLine();//str변수에 저장 // sc.nextLine(); -> 사용자 입력 메소드 
//		  System.out.println("입력받은 내용: "+ str);
		 
		
//		System.out.println("숫자를 입력해주세요>");
//		int nextInt=sc.nextInt(); // 숫자를 입력받을수 있음
//		System.out.println("입력 받은 숫자:"+ nextInt);
	
		  //※nextInt나 nextLine를 연달아 쓸경우 다음 입력이 실행되지 않는 버그 발생(취약점)
	
		
		
//		System.out.print("숫자입력>");
//		int num = Integer.parseInt(sc.nextLine()); //형변환 메소드 Integer.parseInt 를 입력하고 다른 자료형을 입력받을 경우 오류발생
//		System.out.println("입력받은 숫자:" + num);
		
		
		
		//문제: 자신의 이름을 저장할 변수를 선언하고 Scanner를 사용해 변수에 이름을 저장해주세요.
//		Scanner myName = new Scanner(System.in);		
//		System.out.println("이름을 입력해주세요");
//		String strName = myName.nextLine();
//		System.out.println("입력받은 이름 "+ strName);
		
		
		//문제2:자신의 나이를 저장할 변수를 선언하고 Scanner를 사용해 변수에 나이를 저장해주세요.
//		Scanner myAge = new Scanner(System.in);
//		System.out.println("나이를 입력해주세요");
//		int myStr = Integer.parseInt(myAge.nextLine());
//		System.out.println("입력받은 나이:" + myStr);
		
		
		
		//문제: 이름과 나이를 출력해주세요
		
		Scanner myName = new Scanner(System.in);	//스캐너는 한번만 써도 됨, 선언한 클래스로 이후 형변환까지 적용
		System.out.println("이름을 입력해주세요");
		String myNameStr = myName.nextLine();
		
		System.out.println("나이를 입력해주세요");
		int myAgeStr = Integer.parseInt(myName.nextLine());
		
		System.out.println("이름은" +myNameStr+ "이고 나이는" +myAgeStr+ "입니다");
		
	}

}


