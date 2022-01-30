package f_game;

public class Character {


		//이름
		//체력
		//레벨
		//경험치
		//직업
		
		String name; //이름
		int maxHp;   //최대체력
		int maxMp;	 //최대마나
		int hp; 	 //체력
		int mp;		//마나
		int att;	//공격력
		int def;    //방어력
		int level;  //레벨
		int exp;	//경험치
		Item[] items; 	//보유아이템
		
		
		
	Character(String name, int hp, int mp, int att, int def){
		this.name = name; //이름
		this.maxHp = hp;   //최대체력
		this.maxMp = mp;	 //최대마나
		this.hp = maxHp; 	 //체력
		this.mp = maxMp;		//마나
		this.att = att;	//공격력
		this.def = def;    //방어력
		this.level = 1;  //레벨
		this.exp = 0;	//경험치
		this.items = new Item[10]; 	//보유아이템
	}
		
	void status() {
		System.out.println("============ 상태 ============");
		System.out.println("이름: "+name);
		System.out.println("레벨: "+level+"("+exp+"/100)");
		System.out.println("체력: "+hp+"/"+maxMp);
		System.out.println("마나: "+mp+"/"+maxMp);
		System.out.println("공격력: "+att);
		System.out.println("방어력: "+def);
		System.out.println("============ 아이템 ============");
		for(int i=0; i< items.length; i++) {
			if(items[i] != null) {
				System.out.println(items[i]);
			}
		}
		System.out.println("============--============");
		
	}
	
	
	
	
	
	//공격하는 메서드
	void attack(Monster m) {
		int damage = att - m.def;
		//데미지가 음수가 되지않도록
		damage =damage <= 0 ? 1 : damage;  //데미지가 0이하일때 최소한 1이상의 데미지를 줄수있게
		m.hp -= damage <= m.hp ? damage : m.hp;
		System.out.println(name+"가 공격으로 "+m.name+"에게"+damage+"만큼 데미지를 주었습니다.");
		System.out.println(m.name +"의 남은체력"+m.hp);
	}   
	
	
	//경험치를 얻는 메서드
	void getExp(int exp) {
		this.exp += exp;
		System.out.println(exp+"의 경험치를 획득하였습니다.");

	
	//100이 되면 레벨업
	while(100<=this.exp) {
		levelUp();
		this.exp -= 100;
		}
	}
	
	//레벨업 매서드
	void levelUp() {
		level++;
		maxHp += 10;
		maxMp += 5;
		att += 2;
		def += 2;
		hp += maxHp;
		mp += maxMp;
		System.out.println("레벨업!");
	}
	
	//아이템을 얻는 메서드
	void getItem(Item item) {
		System.out.println(item.name+"을 획득하였습니다.");
		for(int i=0; i<items.length; i++) {
			if(items[i] == null) {
				items[i] = item;
				break;
			}
		}
		
		maxHp += item.hp;
		maxMp += item.mp;
		att += item.att;
		def += item.def;
		
		
		
		
		
		
		
	}
	
	
	
	
	

}





