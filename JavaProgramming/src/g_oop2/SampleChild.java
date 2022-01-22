package g_oop2;

public class SampleChild extends SampleParent {
	void childMethod() { 
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); //상속받은 변수
		System.out.println(method(7,13)); //상속받은 메서드
	}
	
	//오버라이딩 -> 상속받은 메서드의 내용을 바꾸는것.
	//super, super() -> 부모클래스의 맴버와 자식클래스의 맴버가 똑같을때 사용
	//		super() 자식클래스의 생성자에서 부모클래스의 생성자를 호출할 때 
	//다형성 -> 부모타입의 변수로 자식타입의 변수를 사용하는것.
	
	
	
	//오버라이딩: 상속받은 메서드의 내용을 재정의하는 것
	@Override //어노테이션: 클래스, 변수, 메서드 등에 표시해 놓는 것 
			  //-> 오버라이딩된 메서드가 아닐때 컴파일에러를 발생시킴
	int method(int a,int b) { //리턴타입, 메서드명, 파라미터 모두 같아야한다.
		return a * b;
	}
	
	//super, super()
	int var;
	
	void test(double var) {
		System.out.println(var); //지역변수 우선순위1
		System.out.println(this.var); //인스턴스 변수
		System.out.println(super.var); //부모클래스의 인스턴스 변수
		// super: 부모클래스의 맴버와 자식클래스의 맴버가 이름이 중복될때 둘을 구분하기 위해 사용한다.
	}
	
	
	
	SampleChild(){
		super(); //부모클래스의 생성자 호출 -> 만약 생략한다면 컴파일시 자동으로 넣어주게된다.
		//super();은 this()가 없는 생성자에서만 호출한다.
		//this();  //같은 클래스내의 생성자 호출
		//생성자라인에서 가장첫줄에서만 사용가능, 따라서 this(); super(); 둘중하나만 사용가능함
	}
	
	
	
	//다형성: 부모타입의 변수로 자식타입의 객체를 사용하는것
	public static void main(String[] args) {
		SampleChild sc = new SampleChild(); //일반적인 객체생성
	
		SampleParent sp = new SampleChild(); //다형성
		//변수(부모)의 타입에 있는 맴버만 사용할 수있다.
		System.out.println(sp.var);
		sp.method(10,20);
		
		//객체(자식)의 타입에 있는 멤버는 사용할 수 없다.
//		sp.ChildMethod(); //사용불가
//		sp.test(); //사용불가
	// 다형성을 사용하는이유:  
	
	}
	
	
	
	
	
	
	

}
