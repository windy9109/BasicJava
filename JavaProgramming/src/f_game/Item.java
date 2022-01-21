package f_game;

public class Item {

	String name; //이름
	int hp; 	 //체력
	int mp;		//마나
	int att;	//공격력
	int def;    //방어력

	
	Item(String name, int hp, int mp, int att, int def){
		this.name = name; //이름
		this.hp = hp; 	  //체력
		this.mp = mp;	  //마나
		this.att = att;	  //공격력
		this.def = def;   //방어력
	}
	
	
	//아이템에 정보를 제공하는 메서드
	public String toString() { // toString을 썼을때 주소가 아니라 리턴된 내용이 출력됨
		String info = name +" :";
		if(0 < hp) info += "체력+"+hp;
		if(0 < mp) info += "마나+"+mp;
		if(0 < att) info += "공격력+"+att;
		if(0 < def) info += "방어력+"+def;
		return info;                                                                                                                                                                                          
	}
	
	
}
