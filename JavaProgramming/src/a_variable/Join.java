package a_variable;

import java.util.Scanner;

public class Join {

	public static void main(String[] args) {
		//다음과 같은 프로그램을 작성해주세요. 
		/*
		 * ====================회원가입====================
		 * 아이디> admin 
		 * 비밀번호(4자리숫자)1234
		 * 이름> 홍길동
		 * 나이>99
		 * 키>185.5
		 * =============================================
		 * 회원가입 완료!!
		 * =============================================
		 * 아이디: admin
		 * 비밀번호: 1234
		 * 이름: 홍길동
		 * 나이:99세
		 * 키:185.5cm
		 * =============================================
		 * 
		 * ※회원가입창 만들기(입력출력)
		 */
				
		Scanner Infor = new Scanner(System.in); 
		
		System.out.println("아이디:");
		String Id = Infor.nextLine();
		System.out.println("비밀번호(4자리숫자):");
		int Pass = Integer.parseInt(Infor.nextLine());
		System.out.println("이름:");
		String Name = Infor.nextLine();
		System.out.println("나이:");
		int Age = Integer.parseInt(Infor.nextLine());
		System.out.println("키:");
		float Height = Infor.nextFloat();
		System.out.println("=============================================");
		System.out.println("회원가입 완료!!");
		System.out.println("=============================================");
		System.out.println("아이디:"+Id);
		System.out.println("비밀번호:"+Pass);
		System.out.println("이름:"+Name);
		System.out.println("나이:"+Age);
		System.out.println("키:"+Height);
		System.out.println("=============================================");
		
	}

}
