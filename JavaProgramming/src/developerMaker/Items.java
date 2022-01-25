package developerMaker;

public class Items {

	//아이템에 필요한것 출력하기
	
	String name; //아이템 이름
	int hp;
	int intelligent;
	int stress;
	
	
	Items(String name, int hp, int intelligent, int stress){
		this.name = name; //플레이어 이름
		this.hp = hp; //체력
		this.intelligent = intelligent; //지능
		this.stress = stress; //스트레스
				
	}
	
	//아이템정보를 제공하는 메서드
	public String toString() {
		String info = name+": ";
		if(0<hp) info += "체력+"+hp;
		if(0<intelligent) info += "지능+"+intelligent;
		if(0<stress) info += "스트레스+"+stress;
		return info; 
		
	}
	
	
	
}
