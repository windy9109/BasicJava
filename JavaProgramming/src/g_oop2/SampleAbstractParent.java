package g_oop2;

//추상메서드를 하나라도 가지고 있으면 추상클래스
public abstract class SampleAbstractParent {

	//추상메서드(내용이 없는 메서드)
	void method() {
		
	}
	//추상메서드
	abstract void abstractMethod();
	//추상메서드가 있는 클래스는 객체생성 못하므로 abstract를 같이 붙여준다
	//추상메서드는 사용못함
	//다른클래스가 상속받기위해서 만듦. 부모로서 사용함.
	//메서드는 있고 내용이 모두 다를때 사용
	
	
}


//자식클래스
class SampleAbstractChild extends SampleAbstractParent{
	//추상메서드를 상속받으면 반드시 오버라이딩 해줘야함
	//추상클래스는 자식클래스에게 오버라이딩을 강제하는 역할을 함
	
	@Override
	void abstractMethod() {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
