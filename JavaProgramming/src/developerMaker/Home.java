package developerMaker;

import java.util.Scanner;

public class Home{


	

	
	//확률로 집에서 공부를 한다.(+지능), 확률로 악몽을 꾼다.
	static void homeEvent(Player p) {
		int Dnum =(int)(Math.random()*100)+1;
		if( Dnum > 1 && Dnum < 25 ) {
			p.intelligent += 10;
			System.out.println("[EVENT] 심심하네 집에서 공부나 할까? 지능 +10");
		}
		if( Dnum > 26 && Dnum < 50 ) {
			p.stress += 10;
			System.out.println("[EVENT] 악몽을 꾼뒤 컨디션이 나빠졌다. 스트레스 +10");
		}
	}
	


		
	
	
	
	
	
	
}