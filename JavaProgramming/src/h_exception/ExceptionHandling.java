package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args) {
		/*
		 * 
		 * 에러
		 * - 컴파일 에러: 컴파일 시에 발생되는 에러(빨간줄)
		 * - 논리적에러: 실행은 되지만, 의도와는 다르게 동작하는것(버그)
		 * - 런타임 에러: 실행시에 발생되는 에레(콘솔창 빨간글씨)
		 * 
		 *  런타임에러 
		 *  - 런타임 에러발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 *  - 에러: 프로그램코드에 의해 수습될 수 없는 심각한 오류
		 *  - 예외: 프로그램코드에 의해서 수습될수 있는 다소 미약한 오류
		 *  
		 *  예외
		 *  - 모든예외는 Exception 클래스의 자식클래스이다
		 *  - RuntimeException 클래스와 그 자식들은 예외처리가 강제되지않는다.
		 *  - [ RuntimeException 클래스와 그 자식들을 제외한 ]
		 *    Exception 클래스의 자식들은 예외처리가 강제된다.
		 *    
		 * 예외처리(try-catch)
		 * - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지 할 수 있다.
		 * - try {} cath(Exception e){}
		 * - try 블럭안의 내용을 실행중 예외가 발생하면 catch로 넘어간다.
		 * - catch의 파라미터로 처리할 예외를 지정해 줄수 있다.
		 * -발생한 예외와 일치하는 catch블럭안의 내용이 수행된후 try-catch를 빠져나간다.
		 * -발생한 예외와 일치하는 catch가 없을 경우 예외는 처리되지 않는다.
		 * 
		 * 
		 * 
		*/
		
		
//		int result = 10/0;
//		System.out.println(result);
		
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at h_exception.ExceptionHandling.main(ExceptionHandling.java:37)
		// 런타임에러 발생

		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		//에서 ArithmeticException를 catch에 넣는다
		
		//예외메세지작성
		try {
			int result = 10/0;
			System.out.println(result);
		}catch(ArithmeticException e) {
			e.printStackTrace();
			
		}
		
		
		
		try {
			int result = 10/0;
			System.out.println(result);
		}catch(ArithmeticException | IndexOutOfBoundsException e) {
			//둘중하나의 예외가 발생했을때 e로 처리함
			e.printStackTrace();
			
		}catch(NullPointerException e) {
			
		}//모든 예외한번에 처리하기
		catch(Exception e) {
			
		}
		
		
		//입력받는값 예외처리 TEST
//		System.out.println("숫자입력>");
//		int input = ScanUtil.nextInt();
//		System.out.println(input);
		
		
		test1();
		
		
		
		
	}

	private static void test1() {
		test2();
		
	}

	private static void test2() {
		//System.out.println(10/0); 
		//예외가 발생했을때 제일위의 예외로 들어가면됨
		
		try {
			new FileInputStream(""); //여러개일경우 내가 만든것중에 맨위에것 하나를 찾으면됨
			//at h_exception.ExceptionHandling.test2(ExceptionHandling.java:99)
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}




