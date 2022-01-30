package h_exception;

import java.io.IOException;

public class ThrowException {
public static void main(String[] args) {
	
	
		/*
		 * 강제로 원하는 위치에 예외발생시키기
		 * - throw new Exception();
		 * 
		*/
	
		try {
			throw new IOException();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		//NullPointerException
		//null포인터 예외
		String str =null; //안에 객체가 없다는뜻
		System.out.println(str.equals("abc"));
		
		
		//ArrayIndexOutOfBoundsException
		//배열이 인덱스의 범위를 벗어났다는 예외
		int[] arr = new int [10];
		for(int i=0; i<=arr.length; i++) { //10번 인덱스가 존재하지 않으므로 마지막에 오류발생
			System.out.println(arr[i]);
		}
		
		
		
		
		
		
	
	}

}
