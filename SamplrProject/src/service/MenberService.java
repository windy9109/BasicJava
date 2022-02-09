package service;

public class MenberService {

	//싱글톤패턴: 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MenberService() {
		
	}
	
	private static MenberService instance; //객체를 보관할 변수
	public static MenberService getInstance() {
		if(instance == null) {
			instance = new MenberService();
		}
		return instance;
	}
	
}
