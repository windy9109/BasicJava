package g_oop2.test;

import g_oop2.AccessMisifier;

public class AccessTest extends AccessMisifier{
	
	
	
	public static void main(String[] args) {
		AccessMisifier am = new AccessMisifier();
		System.out.println(am.publicVar);
		am.publicMethod();
		
		//상속받으면 접근가능하지만 이렇게는 불가능
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
		
		//이제가능
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
		
		
		
//		System.out.println(am.defaultVar);
//		am.defaultMethod();

		//접근불가
//		System.out.println(am.privateVar);
//		am.privateMethod();
		
		

		/*
		 * 접근제어자를 사용하는이유
		 * - 데이터를 보호하기위해
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 * 
		*/		
		
		
	}
	
	

}
