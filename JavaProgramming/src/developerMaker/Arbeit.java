package developerMaker;

import java.util.Scanner;

public class Arbeit extends Place {

	Arbeit(String name, int money, int hp, int intelligent, int stress, Items[] Item){
		super(name, money, hp, intelligent, stress, Item);
	}
	
	
	
	 
	
	
	//이벤트
	static void bonus( Player t ){
			int bonusMoney;
			int consumer;
			int ANum = (int)(Math.random()*100)+1;
			//확률로 보너스를 준다.(소지금+)
			if(ANum > 1 && ANum < 25) {
				bonusMoney = (int)(Math.random()*10000)+10000;
				t.money += bonusMoney;
				System.out.println("[EVENT]오늘은 일을 잘했다! 보너스"+bonusMoney+"원을 받았다.");
			}
			
			
	
			
			//확률로 진상손님을 만난다.(체력이 70이상일때 진상손님을 만나면 싸움선택가능)
			if(ANum > 26 && ANum < 50) {
				System.out.println("[EVENT] 진상손님을 만났습니다.(체력 70이상 전투가능)");
				if(t.hp >= 70) { 
					System.out.println("싸우시겠습니까?  [1.싸운다] [2.싸우지 않는다]"); 
					Scanner js = new Scanner(System.in);
					int jss = Integer.parseInt(js.nextLine());
								if( jss == 1) {
								consumer = (int)(Math.random()*50)+1;
									if(t.att > consumer) {
										t.stress -= 10; 
										t.hp += consumer;
										
										System.out.println("진상을 물리쳤다. 체력+"+consumer+", 스트레스-10");
									}else if(t.att < consumer) {
										t.stress += 10; 
										t.hp -= consumer;
										System.out.println("노력했으나 물리칠수 없었다. 받은 데미지"+consumer+", 스트레스+10");
									}
									
								}else {
										t.stress += 10; 
										t.hp -= 10;
										System.out.println("손님을 잘 달래서 보냈다. 오늘하루는 고단하다. 체력-10, 스트레스+10");
									}
								}
					else {
						t.stress += 10; 
						t.hp -= 10;
						System.out.println("손님을 잘 달래서 보냈다. 오늘하루는 고단하다. 체력-10, 스트레스+10");
					}

			}
		}
		
	
	
	
	
	
	
	
	
	
	
	
}
