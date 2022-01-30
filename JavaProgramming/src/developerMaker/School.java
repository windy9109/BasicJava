package developerMaker;


public class School extends Place {
	
	School(String name, int money, int hp, int intelligent, int stress, Items[] Item){
		super(name, money, hp, intelligent, stress, Item);
	}
	

	
	
	Items itemDrop() {
			return Item[(int)(Math.random()*Item.length)];
			//아이템 드랍
	}
	

	
	
	

}
