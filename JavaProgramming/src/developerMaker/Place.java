package developerMaker;

public class Place {

	
	
	String name;
	int money;
	int hp;
	int intelligent;
	int stress;
	Items[] item;
	
	
	Place(String name, int money, int hp, int intelligent, int stress){
		this.name = name; //장소 이름
		this.money = money; //소지금
		this.hp = hp; //체력
		this.intelligent = intelligent; //지능
		this.stress = stress; //스트레스
		this.item = new Items[10]; //아이템
				
	}
	
	
	
}
