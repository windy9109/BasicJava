package e_oop.restaurant;

import java.util.Arrays;

public class Alba {

	//주문받는 메서드
	//주문받기 위해 필요한것? 없음
	//주문받은 후 보스에게 줄 것? return 주문서
	
	String[] order() {
		System.out.println("주문하시겠습니까?");
		return new String[] {"짜장면","탕수육"};
	}
	
	
	
	//서빙하는 메서드 
	//서빙을 위해 필요한것? 파타라미터: 음식
	//서빙후 보스에게 줄것? 리턴: 없음
	void serving(String[] foods) {
		System.out.println(Arrays.toString(foods)+"나왔습니다. 맛있게 드세요.");
	}
	
	
	//계산하는 메서드
	//계산하기 위해 필요한것? 주문서
	//계산후 보스에게 줄것? 없음
	
	void pay(String[] order) {
		System.out.println("2만원입니다. 안녕히가세요.");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
