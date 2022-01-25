package g_oop2;

public interface SampleInterface {
	
	//인터페이스의 모든 맴버변수는 public static final 제어자를 사용해야한다.
	public static final int NUM1 =1;
	
	//모든 맴버변수의 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 =2;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다.
	public abstract void method1();
	
	//모든메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();
	
	
	//상수와 추상메서드만 가질수 있음
	//부모의 역할만 하고 상속만 해줄수있음
	
}



class SampleImplment implements SampleInterface, SampleInterface2{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}
	


	
	
	
	//인터페이스를 상속받을때는 implements를 쓴다.
	//ctrl + 1 => 오버라이딩
	
	
}

//여러개의 인터페이스로부터 상속받을수 있다.




interface SampleInterface2{
	void method1();
	void method3();
	
}





