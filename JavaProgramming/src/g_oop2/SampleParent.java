package g_oop2;

public class SampleParent {
	/*
	 * 상속 
	 * - 기존의 클래스를 물려받아 새로운 클래스를 만드는 것이다.
	 * - class 자식 클래스명 extends 부모클래스명 {}
	 * - 부모클래스의 생성자와 초기화 블력을 제외한 모든 맴버를 물려받는다.
	 * - 하나의 클래스만 상속받을 수 있다. => 부모가 하나여야함
	 * - 상속받지 않는 모든 클래스는 object클래스를 상속받는다. object클래스는 모든 클래스의 부모클래스임.
	 * - 자식클래스는 부모클래스의 맴버외의 새로운 맴버를 가질 수있으므로 자식클래스는 부모클래스보다 크거나 같다.
	 * - 두개 이상의 클래스를 만드는데 공통된 맴버가 있는 경우 부모클래스로 만든다.
	 * 
	*/
	
	
	String  var;
	
	{
		var ="초기화 블럭은 물려주지 않는다";
	}
	
	SampleParent(){
		var = "생성자도 물려 주지않는다";
	}
	
	
	int method(int a, int b) {
		return a+b;
	}
	
	
}
