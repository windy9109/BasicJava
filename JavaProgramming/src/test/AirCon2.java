package test;

import e_oop.AirCon;
import e_oop.ScanUtil;

public class AirCon2 {

	boolean power = false;
	int temperature = 24;
	int wind = 2;
	
	final int MIN_TEMPERATURE = 18;
	final int MAX_TEMPERATURE = 30;
	final int MIN_WIND = 1;
	final int MAX_WIND = 3;
	
	void power() {
		power = !power;
		System.out.println(power ? "켜짐" : "꺼짐");
	}
	
	void temperatureUp() {
		if(power) {
			if(temperature < MAX_TEMPERATURE) {
				temperature++;
			}
			System.out.println("현재온도 : " + temperature);
		}
	}
	
	void temperatureDown() {
		if(power) {
			if(MIN_TEMPERATURE < temperature) {
				temperature--;
			}
			System.out.println("현재온도 : " + temperature);
		}
	}
	
	void changeWind() {
		wind++;
		if(MAX_WIND < wind) {
			wind = MIN_WIND;
		}
		System.out.println("현재풍량 : " + wind + "단계");
	}
	
	public static void main(String[] args) {
		AirCon2 ac = new AirCon2();
		
		while(true) {
			System.out.println("1.전원  2.온도+  3.온도-  4.풍량  0.종료>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: ac.power(); break;
			case 2: ac.temperatureUp(); break;
			case 3: ac.temperatureDown(); break;
			case 4: ac.changeWind(); break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}
}








