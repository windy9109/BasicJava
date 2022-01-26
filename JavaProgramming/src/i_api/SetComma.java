package i_api;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 출력해주세요.
		//1234567 -> 1,234,567
		//입력받을때 string탑입으로 받는다.

		
		//내답
		System.out.println("문자를 입력해주세요");
		String num = ScanUtil.nextLine();
		
		
		int max=0;
		int inNumber;
		
		String[] num1 = new String[num.length()];
		for(int i=0; i<num.length(); i++) {
			num1[i] = num.substring(i,i+1);
			if(i%3 == 0) {
					max = i;}
			
			

			
		}
		
		inNumber = num.length() - (max+1);
		for(int i=0; i<num.length(); i++) {
			System.out.print(num1[i]);
		if(i==inNumber) {
		System.out.print(",");
		}
		if(i > inNumber && (i-inNumber)%3 == 0 && i+1 != num.length() ) {
			System.out.print(",");
		}
		
	}
		
		
		
	}

}
