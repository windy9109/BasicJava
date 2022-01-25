package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		
		/*
		 * finally
		 * - 필요에 따라 try-cath 뒤에 finally를 추가 할수 있다.
		 * - finally는 예외의 발생여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수 선언; 변수 선언){} catch(Exceptioin e){}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 * 		
		*/		
		
		//파일의 내용을 읽을 수 있는 프로그램
		FileInputStream fis = null; //파일읽기
		//fis = new FileInputStream("d:/file.txt"); //=> 예외처리를 하지않아서 발생하는 에러
		
		
		
		//예외처리 해줌
		try {
			fis = new FileInputStream("d:/file.txt");
			
			//fis.close(); //파일 사용후 반납해준다. 
			//반드시 실행되어야 하는 구문이기때문에 finally안에 넣어준다.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ctrl + D > 한줄씩 삭제
		//Alt + 방향키 > 위치이동 
		//ctrl + Alt + 방향키 > 한줄복사
		
		
		
		//자동 자원반환(JDK1.7)
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){
			String str = "아무내용이나 작성합니다.";
			
			byte[] bytes = str.getBytes();
			
			for(int i =0; i<bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
