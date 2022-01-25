package g_oop2;

public class AccessTest {
	
	
	
	public static void main(String[] args) {
		AccessMisifier am = new AccessMisifier();
		System.out.println(am.publicVar);
		am.publicMethod();

		System.out.println(am.protectedVar);
		am.protectedMethod();
		
		System.out.println(am.defaultVar);
		am.defaultMethod();

		//접근불가
//		System.out.println(am.privateVar);
//		am.privateMethod();
		
		
		
		
	}
	
	

}
