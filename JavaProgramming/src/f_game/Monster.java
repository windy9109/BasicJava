package f_game;

public class Monster {

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
	
	
	Monster(String name, int hp, int mp, int att, int def,int level, int exp, Item[] items){
		this.name = name; //이름
		this.maxHp = hp;   //최대체력
		this.maxMp = mp;	 //최대마나
		this.hp = this.maxHp; 	 //체력
		this.mp = this.maxMp;	 //마나
		this.att = att;	//공격력
		this.def = def;    //방어력
		this.items = items; 	//보유아이템
		this.exp = exp;
		this.level= level;
	}
	
	
	//공격하는 메서드
	void attack(Character c) {
		int damage = att - c.def;
		//데미지가 음수가 되지않도록
		damage =damage <= 0 ? 1 : damage;  //데미지가 0이하일때 최소한 1이상의 데미지를 줄수있게
		c.hp -= damage <= c.hp ? damage : c.hp;
		System.out.println(name+"가 공격으로 "+c.name+"에게"+damage+"만큼 데미지를 주었습니다.");
		System.out.println(c.name +"의 남은체력"+c.hp);
	}
	
	
	//아이템 드랍
	Item itemDrop() {
		return items[(int)(Math.random()*items.length)];
	}
	
	
	
}
