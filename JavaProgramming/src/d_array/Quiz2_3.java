package d_array;

import java.util.Arrays;

public class Quiz2_3 {

	public static void main(String[] args) {
		/*
		 * 1~5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만드시오.
		 * [3, 1, 2, 1, 3, 5, 1, 3, 4, 2]
		 * [3, 1, 2, 5, 4]
		 *  
		*/
		
		//교수님답
		
		int[] arr = new int[10]; // 10크기의 숫자타입 arr배열을 넣은뒤
		for(int i=0; i<arr.length; i++) { //배열에 랜덤값 출력
			arr[i] = (int)(Math.random()*5)+1;
			
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		
		int[] temp = new int[5]; //5자리 temp배열 생성
		

		int count = 0; //카운트값(배열의 크기 지정)
		for(int i=0; i<arr.length; i++) { //
			boolean flag = true;
			
			for(int j=0; j<temp.length; j++) {
				if(arr[i] == temp[j]) {
					flag = false; //중복인지 확인
				}
			}
			if(flag) {
				temp[count++] = arr[i]; //중복아닐때 출력
			}
			
		}
		int[] result = new int[count];
		for(int i = 0; i<result.length; i++) {
			result[i] = temp[i];
		}
		
		System.out.println(Arrays.toString(result));
		
		
		
		
		
		

	}

}
