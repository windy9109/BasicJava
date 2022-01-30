package e_oop;

public class ClassMaker {

	//전역변수 하나를 선언 및 초기화 해주세요. 
	
	int number=0;
	
	//리턴타입과 피라미터가 없는 메서드 하나를 만들어주세요.
	//메서드안에서 전역변수를 출력해주세요.
	
	void meth() {
		System.out.println(number);
	}
	
	//전역변수와 동일한 타입의 리턴 타입이 있고 파라미터는 없는 메서드 하나를 만들어주세요.
	//메서드 안에서 전역변수를 리턴해주세요.
	
	int meth2() { //리턴이 있으면 안에 반드시 리턴할 값을 적어줘야함.
		return number;
	}
	
	
	//리턴타입은 없고 파라미터가 있는 메서드 하나를 만들어주세요.
	//메서드안에서 파라미터를 출력해주세요.
	
	
	void meth3(String number2) {
		if(number2.equals("")) {
			return;
		}
		System.out.println(number2);
		return; //void안의 return의 경우 메서드를 종료시키는 역할을 함.
	}
	
	
	//int타입의 리턴타입과  int 타입의 파라미터 두개가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요
	
	int meth4(int x1,int x2) {
		return x1*x2;
		//return의 역할: 값을 돌려주는 역할과 메서드를 종료시키는 두가지 역할을 함.
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
