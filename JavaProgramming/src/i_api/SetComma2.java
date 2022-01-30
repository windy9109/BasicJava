package i_api;

import e_oop.ScanUtil;

public class SetComma2 {
	
	
	//교수님답
	public static void main(String[] args) {
		System.out.println("숫자입력>");
		String num = ScanUtil.nextLine();
		String res ="";
		
		int count =0;
		for(int i = num.length()-1; i>=0; i--) {
			res = num.charAt(i)+ res;
			count++;
			if(count %3 == 0 && count != num.length()) {
				res =","+res;
			}
		}
		System.out.println(res);
	}
	

}
