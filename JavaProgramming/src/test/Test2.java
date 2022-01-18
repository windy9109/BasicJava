package test;

public class Test2 {

	
	
	public static void main(String[] args) {
	
		TestClass[] test0 = new TestClass[3];
		
		for(int i=0; i<test0.length; i++) {
			test0[i] = new TestClass();
			test0[i].sum=(int)(Math.random()*101);
			
			System.out.println(test0[i].sum);
		}
		
		
		
		
		
		
	}
	
}
