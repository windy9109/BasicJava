package d_array;

import java.util.Arrays;

public class Quiz2_2 {

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
		 * 
		 * 
		*/
		
		//내답
		
		//중복된값을 0으로 바꿔주고 중복되지않은 수 카운트
		int count=0;
		for(int i= 0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = 0;
				}
			}
			if(arr[i] != 0) {
				 count++; } //중복되지 않은수 카운트
		}
		

		//2자리씩 비교해서 0을 뒤로 밀어줌
		int temp=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++ ) {
				if(arr[j] == 0) { //0을 만나면 바꿔줌
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

				}
			}
		}
		
		
		//중복되지 않는 크기를 가진 배열 선언
		int[]arr2 = new int[count];
		
		
		
		//중복되지 않는 크기를 가진 배열arr2에 0을 제외한 arr값을 삽입. 
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = arr[i];
		}
		


		System.out.println(Arrays.toString(arr2));
		


	}

}





