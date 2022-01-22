package d_array;

import java.util.Arrays;

public class Quiz2 {

	public static void main(String[] args) {
		
		int[]arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] =(int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		/* 
		 * 1~5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만드시오.
		 * [3, 1, 2, 1, 3, 5, 1, 3, 4, 2]
		 * [3, 1, 2, 5, 4]
		*/
		
		//내 오답: 배열로 출력해야함

		int num =0;
		for(int i= 0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = num;
				}
			}
		}

		
		System.out.print("[");
		for(int i= 0; i<arr.length; i++) {
			if(arr[i] != 0) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.print("]");
		
		


	}

}
