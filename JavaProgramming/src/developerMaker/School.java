package developerMaker;

public class School extends Place {
	
	School(String name, int money, int hp, int intelligent, int stress){
		super(name, money, hp, intelligent, stress);
	}
	
	//전체적으로 필수return하고 확률체크하는 메서드만들기
	//학교에 간다(1회차에 지능이 +10, 체력-10 된다.)
	
	//확률로 공부가 잘된다!(+지능), 랜덤값1~10
	
	//확률로 공부가 잘 안된다(지능 변화없음, +스트레스), 랜덤값 11~20
	
	//확률로 혼자공부하는 자바를 선물 받는다.(+지능), 랜덤값 21~30
	
	//랜덤값 31~100까지는 이벤트없음
	
	
	

}
