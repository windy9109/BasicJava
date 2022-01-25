package h_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		/*
		 * 메서드 예외 선언하기
		 * - 메서드 호출시 발생할수 있는 예외를 선언해줄수 있다.
		 * - void method() throws IOException{}
		 * - 예외를 선언하면 예외처리를 하지않고 자신을 호출한 메서드로 예외처리를 넘겨준다.
		 * 
		*/
		
		
		try {
			method();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	private static void method() throws IOException { 
		//예외가 발생했을때 IOException를 쓸수있다.
		throw new IOException();
		
		
		
		
		
	}

}











