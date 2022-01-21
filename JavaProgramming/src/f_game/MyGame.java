package f_game;

import e_oop.ScanUtil;

public class MyGame {

	//게임에 등장하는것을 변수로 만듦
	
	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("가렌",100,50,20,10);
		items =new Item[10];
		items[0] =new Item("무한의대검",0,0,10,0);
		items[1] =new Item("가시갑옷",0,0,0,10);
		
	}
	
	public static void main(String[] args) {
		new MyGame().start();

	}
	
	
	
	void start() {
		//System.out.println(c); //객체생성 없어도 사용가능
		while(true) {
			System.out.println("1.내정보  2.사냥   0.종료>");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1: c.status(); break;
			case 2: hunt(); break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0); //프로그램 강제종료
				}
			}
		}


			void hunt() {
				Monster m = new Monster("고블린", 20, 10, 15,10, 1, 150, new Item[] {items[0],items[1]});
			System.out.println(m.name+"를 만났습니다. 전투를 시작합니다");
			
			int input = 0;
			battle : while(true) {
				System.out.println("1.공격  2.도망>");
				input = ScanUtil.nextInt();
				switch(input) {
				case 1:
					c.attack(m);
					if(m.hp <= 0) {
						System.out.println(m.name +"를 처치하였습니다.");
						c.getExp(m.exp);
						c.getItem(m.itemDrop());
						break battle;
					}
				m.attack(c);
				break;
				case 2: System.out.println(m.name+"으로 부터 도망쳤습니다.");
				break battle;
					
				}
				
			}
			
			
		//게임만들기 어떤게임이던지 상관없음
	    //기한은 27일 까지 > 5분 개인발표
		
		
	}
	

}
