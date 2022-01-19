package e_oop;

import java.util.Scanner;

public class AirCon {

	//속성: 변할수 있고 조작가능한것 
	//메서드: 대상이 하는 동작 행동
	
	//버튼하나가 메서드가 됨
	//기능: 온도, 풍량, 전원
	
	//조건1: 전원이 꺼져있을때는 온도와 풍량을 컨트롤 할수없다.
	//조건2: 풍량은 최대 10까지만, 온도는 최소0 ~ 최대30까지 가능
	
	int temperature; //온도
	int windy;
	String power;
	
	final int MIN_TEMPERATURE = 0; //상수는 대문자로 설정하고 final을 붙여준다
	final int MAX_TEMPERATURE=30;
	final int MIN_WINDY=0;
	final int MAX_WINDY=10;
	
	//생성자, 온도와 풍량 값을 받아 저장함
	AirCon(int temperature, int windy){
		this.temperature = temperature;
		this.windy = windy;
	}
	
	//오버로딩
	AirCon(){
		this(15,5);//온도는 15, 바람은 5에서부터 시작함, 전원은 꺼져있음		
	}
	

	//전원
	
	void power(String powerSc) {
		if(powerSc.equals("0")) {
			power = "꺼짐";
		}
		if(powerSc.equals("1")) {
			power = "켜짐";
		}
		System.out.println("전원은"+power+"입니다");
	}
	
	

	
	
	//동작
	//온도를 0~30까지 조절한다.
	void temperature(int temperatureSc) {
		if( power.equals("켜짐")) {
			 temperature += temperatureSc;
			if(MIN_TEMPERATURE <= temperature  &&  MAX_TEMPERATURE >= temperature) {
				System.out.println("현재온도는"+temperature+"입니다.");
			}
		else {
			System.out.println("입력가능한 수치가 아닙니다.");
			}
		}
		
	}
	//풍량을 0~10까지 조절한다.
	void windy(int windySc) {
		if( power.equals("켜짐")) {
			windy += windySc;
			if( MIN_WINDY <= windy && MAX_WINDY >= windy) {
			System.out.println("현재풍량은"+windy+"입니다.");
			}else {
				System.out.println("입력가능한 수치가 아닙니다.");
			}
		}
		
	}
	

	

	
	
	public static void main(String[] args) {
		AirCon ac = new AirCon();
		
		System.out.print("전원을 입력해주세요. 1:시작, 0:종료");
		String powerSc = ScanUtil.nextLine(); //전원
		ac.power(powerSc);
		System.out.println();
		
		
		if(powerSc.equals("1")) {
		System.out.print("원하는 온도의 숫자를 입력해주세요.(+,-) 현재온도 15도(설정가능 범위0~30)");
		int temperatureSc = ScanUtil.nextInt(); //전원
		ac.temperature(temperatureSc);
		System.out.println();
		
		System.out.print("원하는 풍량의 숫자를 입력해주세요.(+,-) 현재풍량 5(설정가능 범위0~10)");
		int windySc = ScanUtil.nextInt(); //풍량
		ac.windy(windySc);
		}
		
	}

	
	
	
}
