package developerMaker;

public class Ending extends Player {

	Ending(String name, int money, int hp, int intelligent, int stress, boolean state) {
		super(name, money, hp, intelligent, stress, state);
		// TODO Auto-generated constructor stub
	}
	
	//인수값으로 받아와서 체크하기
	//이력서를 넣는다 and 지능 70이상일때
		//취업성공엔딩
	
	//이력서를 넣는다 and 지능 70이상 일때 and 상태아픔
		//직업도 얻고 병도 얻고 엔딩(취업에 성공했으나 병을 얻었다.)
	
	//이력서를 넣는다 and 지능 70이하일때
		//취업실패엔딩
	
	//이력서를 넣지않는다 or 취업실패시 and 각클래스 조건 충족시 나오는 엔딩
		//아르바이트를 10회 이상 진행시 정직원엔딩을 볼수있다.
		//집에서 휴식을 10회 이상 진행시 백수엔딩을 볼수있다.
		//학교 10회이상 진행시 대학원 엔딩

	
	//이력서를 넣지 않는다 or 지능 70이하 and 상태가 아픔일때
		//입원엔딩(취업에 실패하고 병을 얻어 입원했다)
	
	
	//지능 70이하 and 각클래스조건 미충족시
		//취준생엔딩(다시 준비하자!)
	
	//이력서를 넣지않는다 and 각클래스 조건 미충족시
		//백수엔딩
	
	

}
