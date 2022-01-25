package developerMaker;

import java.util.Scanner;

public class Player {

	
	String name; //플레이어이름
	int money; //소지금 50000부터 시작
	final int maxHp = 100; //최대 체력 100
	final int maxIntell = 100; //최대 지능 100
	final int maxStress = 100; //최대 스트레스 100
	int hp; //체력은 80부터 시작
	int intelligent; //지능 0시작
	int stress; //스트레스 0시작
	int att; //랜덤
	boolean state; //상태 정상(true)
	String stateName;
	Items[] item; //소지품 없음
	int count = 0;
	int resume; //이력서
	int choice;
	Scanner sc = new Scanner(System.in);
	

	Player(String name, int money, int hp, int intelligent, int stress, boolean state){
		this.name = name; //장소 이름
		this.money = money; //소지금
		this.hp = hp; //체력
		this.intelligent = intelligent; //지능
		this.stress = stress; //스트레스
		this.att = (int)(Math.random()*50)+1;
		this.state = state; //상태
		this.item = new Items[10]; //아이템
		this.resume = resume; //이력서 유무
		this.choice=choice;
		if(state) stateName = "정상";
		else stateName = "아픔";
				
	}
	
	
	

	//화면에 표시할것: 
	//이름/소지금/체력/상태/지능/스트레스
	//현재 게임회차 표시: 2022년 xx월 1~16주째
	
	void printVeiw(){
		System.out.print("Developer Maker - 2022년 xx월 ["+count+"주]\n"
							+ "---------------------------------------------------------\n"
							+"이름\t소지금\t체력\t상태\t지능\t스트레스\t공격력(랜덤)\n"
							+"---------------------------------------------------------\n"
							+name+"\t"+money+"\t"+hp+"\t"+stateName+"\t"+intelligent+"\t"+stress+"\t"+att+"\t\n\n"
							+"어디로 갈까?\n"
							+"1.아르바이트     2.학교\t3.집\t"
							);
		
		int scc = Integer.parseInt(sc.nextLine()); //선택지 저장 변수 scc
		
		
		if(money < 10000 && hp == 0) {
			System.out.println("소지금과 체력이 부족하다. 일단집에서 쉬자");
			scc = 3; //소지금부족, 체력부족 => 집
		}else if(money < 10000) {
			System.out.println("소지금이 부족하다. 아르바이트를 해야한다");
			scc = 1; //소지금이 10000이하 이면 무조건 아르바이트를 해야한다.
		}else if(hp == 0) {
			System.out.println("체력이 부족하다. 일단집에서 쉬자");
			scc = 3; //체력이 0이면 무조건 휴식(집)해야한다.
		}
		hp = hp < 0 ? 0 : hp; //체력 음수불가
		//money = money < 0 ? 0 : money; //소지금 음수가능
		choice = scc;
		
		//스트레스가 80이상, 체력이 20이하이면 상태가 아픔(false)으로 바뀐다.
		if(stress > 80 && hp < 20) {
			state = false;
			System.out.println("컨디션관리 실패! 과로로 몸이 아픕니다.");
		}
		
		//매일 생활비로 일주일(1회차)에 -10000이 소비된다.
		money -= 10000;
		
	}
	
	
	
	
	
	
	//이력서를 넣는다 or 넣지않는다.
	void resume() { //
		System.out.println("마지막회차까지 플레이 했습니다.\n이력서를 넣으시겠습니까? 넣는다[1] / 넣지않는다 [2]");	
		int resume  = Integer.parseInt(sc.nextLine());
	}


	
	//아르바이트에 간다(1회차에 재력이 +10,체력-10,스트레스+10 된다.)

	void ArbeitGo(Place p) {
		money += p.money; //재력+20000
		hp += p.hp;
		stress += p.stress;
		
		System.out.println(p.money+"원을 벌었습니다. 체력"+p.hp+"감소, 스트레스"+p.stress+"증가");
	}
	
	

	
	
	
	
	

}
