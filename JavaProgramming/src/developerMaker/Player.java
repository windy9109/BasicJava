package developerMaker;

import java.util.Scanner;

import e_oop.ScanUtil;
import f_game.Item;

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
	
	void sacanner01() {
		while(true) {
			int scc = ScanUtil.nextInt(); //선택지 저장 변수 scc	
			if(scc == 1 || scc == 2 || scc == 3) {
				
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
			}
		}
	}
	
	void printVeiw(){
		System.out.print("Developer Maker - 2022년 xx월 ["+count+"주]\n"
							+ "---------------------------------------------------------\n"
							+"이름\t소지금\t체력\t상태\t지능\t스트레스\t공격력(랜덤)\n"
							+"---------------------------------------------------------\n"
							+name+"\t"+money+"\t"+hp+"\t"+stateName+"\t"+intelligent+"\t"+stress+"\t"+att+"\t\n\n"
							+"어디로 갈까?\n"
							+"1.아르바이트     2.학교\t3.집\t"
							);
	
		
		while(true) {
			int scc = ScanUtil.nextInt(); 
			//선택지 저장 변수를 예외처리한다. 한글을 입력받으면 예외처리한다.
			if(scc == 1 || scc == 2 || scc == 3) { 
				
				if(money < 10000 && hp == 0) {
					System.out.println("소지금과 체력이 부족하다. 일단집에서 쉬자");
					scc = 3; //소지금부족, 체력부족 => 집
				}
				if(money < 10000) {
					System.out.println("소지금이 부족하다. 아르바이트를 해야한다");
					scc = 1; //소지금이 10000이하 이면 무조건 아르바이트를 해야한다.
				}
				if(hp == 0) {
					System.out.println("체력이 부족하다. 일단집에서 쉬자");
					scc = 3; //체력이 0이면 무조건 휴식(집)해야한다.
				} 
			

			choice = scc;
			break;
			
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
			}//1,2,3외의 숫자를 입력받으면 위의 문구를 출력한다.
		}
	
			
			
		
		
		
		
	}
	
	void livingExpenses(){
		int Cnum = (int)(Math.random()*100)+1;
			//매일 생활비로 일주일(1회차)에 -10000이 소비된다.
			if(choice == 1 || choice == 2 ) {
				money -= 10000;
				System.out.println("생활비로 10000원이 지출되었습니다.\n\n");
			}
			//집에서는 생활비지출이 이루어지지 않을수도있다.
			if(choice == 3) {
				if(Cnum > 1 && Cnum < 25) {
					System.out.println("[EVENT]어쩌다보니 생활비를 아꼇다.(소지금 유지) \n\n");
				}else {
					money -= 10000;
					System.out.println("생활비로 10000원이 지출되었습니다.\n\n");
				}
			}

			//음수방지, 최대값 100이상 방지
			hp = hp < 0 ? 0 : hp;
			hp = hp > 100 ? 100 : hp;
			stress = stress < 0 ? 0 : stress;	
			stress = stress > 100 ? 100 : stress;	
			intelligent = intelligent < 0 ? 0 : intelligent;	
			intelligent = intelligent > 100 ? 100 : intelligent;
			
			//스트레스가 80이상, 체력이 20이하이면 상태가 아픔(false)으로 바뀐다.
			if(stress >= 80 && state == true ) {
					state = false;
					System.out.println("컨디션관리 실패! 과로로 몸이 아픕니다.\n");
			
			}else if(state == false && stress <= 40 && hp >= 40){
				state = true;
				System.out.println("몸이 나아지는것 같다. 컨디션이 정상으로 돌아옵니다.\n");
			}

		}
	
	
	
	
	
	
	//이력서를 넣는다 or 넣지않는다.
//	void resume() { //
//		System.out.println("마지막회차까지 플레이 했습니다.\n이력서를 넣으시겠습니까? 넣는다[1] / 넣지않는다 [2]");	
//		int resume  = Integer.parseInt(sc.nextLine());
//	}


	
	//아르바이트에 간다(선택시 각 스테이더스 반영)
	void ArbeitGo(Place p) {
		money += p.money; //소지금 +20000
		hp += p.hp;
		stress += p.stress;
		
		System.out.println("아르바이트로 "+p.money+"원을 벌었습니다. 체력"+p.hp+"감소, 스트레스"+p.stress+"증가");
	}
	
	

	//학교에 간다(선택시 각 스테이더스 반영)
	void SchoolGo(Place p) {
		intelligent += p.intelligent;
		stress += p.stress;
		hp += p.hp;
		
		System.out.println(p.name+"에서 공부합니다. 지능+"+p.intelligent+", 체력"+p.hp+", 스트레스+"+p.stress);
	}
	
	
	
	//집에 간다(선택시 각 스테이더스 반영)
	void HomeGo() {
		hp += 10;
		stress -= 10;
		System.out.println("이번주는 집에서 휴식합니다. 체력+10, 스트레스-10");
	}

	//아이템을 얻는 메서드
	void itemGet(Items Item) {
		System.out.println("[Item획득] "+Item.name+"을 획득하였습니다. 체력"+Item.hp+", 지능"+Item.intelligent+", 스트레스"+Item.stress);
		for(int i=0; i<item.length; i++) {
			if(item[i] == null) {
				item[i] = Item;
				break;
			}
		}
		hp += Item.hp;
		intelligent += Item.intelligent;
		stress += Item.stress;

		
	}

	
	
	
	

}
