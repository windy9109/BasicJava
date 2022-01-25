package g_oop2;

public class Time {

	
	private int hour; //변수에 직접 접근할수 없음
	private int minute;
	private int second;
	
	
	
	
	
	
	
	//Source > Generate toString()...
	
	
//  내방법	
//	public int getHour() { //getHour 변수값을 불러오기위한 메서드
//		return hour;
//		
//	}
//
//	public void setHour(int hour) { //setHour 변수값을 저장하기위한 메서드
//		for(int i=0; i<hour; i++) {
//			if(hour%24 == 0) {
//				 hour %= 24;
//				}
//			}
//		this.hour = hour;
//	}
//
//	public int getMinute() {
//		return minute;
//	}
//
//	public void setMinute(int minute) {
//		for(int i=0; i<minute; i++) {
//			if(minute%60 == 0) {
//				 hour++;
//				 
//				}
//			minute %= 60;
//			}
//		this.minute = minute;
//	}
//
//	public int getSecond() {
//		return second;
//		
//	}
//
//	public void setSecond(int second) {
//		for(int i=0; i<second; i++) {
//		if(second%60 == 0) {
//			 minute++;
//			}
//		second %= 60;
//		}
//		this.second = second;
//
//		
//	}
//


	
	
	
	//방법2
	public int getHour() { //getHour 변수값을 불러오기위한 메서드
		return hour;
		
	}

	public void setHour(int hour) { //setHour 변수값을 저장하기위한 메서드
		if(hour<0 && hour <24) {
			this.hour = 0;
		}else if(23<hour) {
			this.hour =23;
		}else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute<0 && minute <60) {
			this.minute = 0;
		}else if(59<minute) {
			this.minute =59;
		}else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
		
	}

	public void setSecond(int second) {
		if(second<0 && second<60) {
			this.second = 0;
		}else if(59<second) {
			this.second =59;
		}else {
			this.second = second;
		}

		
	}

	
	//잠깐멈춰주는 메서드
	private void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//매초마다 흘러가도록
	void clock() {
		while(true) {
			System.out.println(toString());
			stop(); //1동안 멈춘다음
			setSecond(second+1); //1초 증가시켜줌
		}
	}
	
	



	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	
	
	
	
}
