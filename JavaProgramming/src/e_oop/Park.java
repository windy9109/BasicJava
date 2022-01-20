package e_oop;

import java.util.Scanner;


public class Park {
//파일하나에 public이 붙은 클래스는 하나여야함.

		//기능: 시동, 주행, 주차
		
		//조건1: 시동이 꺼져있을때는 주행속도를 컨트롤 할수없다.
		//조건2: 주행속도는 최대 100까지만, 기본속도는 50이다.
		//조건3: 주차요금은 1시간에 1000원이다.
	
	
		
		int park; // 주차
		int driv; //주행
		String power;//시동
		
		//상수는 대문자로 설정하고 final을 붙여준다
		final int MIN_DRIV=0;
		final int MAX_DRIV=100;
		
		
		Park(int driv){
			this.driv = driv; //외부에서 값을 받아와야할때 쓴다
			
		}
		
		//오버로딩
		Park(){
			this(50);//주행속도 기본은 50부터		
		}
		

		//시동
		void power(String powerSc) {
			if(powerSc.equals("0")) {
				power = "꺼짐";
			}
			if(powerSc.equals("1")) {
				power = "켜짐";
			}
			System.out.println("시동 "+power+"");
		}
		
		

		
		
		//동작
		//주행: 주행속도는 0~100까지, 기본은 20이다.
		void driv(int drivSc) {
			if( power.equals("켜짐")) {
				 driv += drivSc;
				if( MIN_DRIV <= driv  &&  MAX_DRIV >= driv ) {
					System.out.println("현재 속도는 "+driv+"입니다.");
				}
			else {
				System.out.println("주행가능한 속도가 아닙니다.");
				}
			}
			
		}
		
		//주차: 주차요금은 1시간에 1000원
		void park(int parkSc) {
			if( power.equals("켜짐")) {
				park = parkSc*1000;
				System.out.println("주차요금은 "+park+"원 입니다.");
			
			}
			
		}
		

		

		
		
		public static void main(String[] args) {
			Park ac = new Park();
			
			System.out.print("시동을 거시겠습니까?. 1:시작, 0:종료  ");
			String powerSc = ScanUtil.nextLine(); //전원
			ac.power(powerSc);
			System.out.println();
			
			
			if(powerSc.equals("1")) {
			System.out.print("주행속도를 조절해주세요. 0~100까지 (현재속도 50)  ");
			int drivSc = ScanUtil.nextInt(); //주행속도
			ac.driv(drivSc);
			System.out.println();
			
			System.out.print("주차할 시간을 입력해주세요(1시간: 1000원)");
			int parkSc = ScanUtil.nextInt(); //주차요금
			ac.park(parkSc);
			}
			
		}

		
		
		
	}
