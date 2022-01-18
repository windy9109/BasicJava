package test;

import java.util.Arrays;
import java.util.Scanner;

public class Study5_1 {

	public static void main(String[] args) {
		/*
		 * [5-1]다음은 배열을 선언하거나 초기화 한 것이다.
		 * 잘못된 것을 고르고 그 이유를 설명 하시오.
		 * 
		 * int[] arr[]; 가능-> 2차원배열 선언, 배열 초기화는  arr = new int[][]와 같이 해준다.
		 * int[] arr = {1,2,3,}; * 가능 1,2,3 선언
		 * int[] arr = new int [5];  문제없음
		 * int[] arr = new int [5]{1,2,3,4,5}; -> 불가능  // int[] arr =new int[5]; // or // int[] arr = {1,2,3,4,5}; 로 대체해야 함 
		 * int arr[5]; 불가능 -> int arr[] = new int[5]로 배열의 크기를 선언해주거나 int arr[]; 로 선언한뒤 arr = new int[5]로 초기화해야함
		 * int[] arr[] = new int[3][]; 가능 
		 * 
		 */
		
//		int[] arr[] = new int[3][];
//		System.out.println(Arrays.toString(arr));
		
		
		/*
		 * [5-2] 다음과 같은 배열이 있을때, arr[3].lenght의 값은 얼마인가?
		 * int[][] arr ={
		 * {5,5,5,5,5},
		 * {10,10,10},
		 * {20,20,20,20},
		 * {30,30}
		 * };
		 * 	정답:2
		*/	
		
		
//		int[][] arr ={
//				  {5,5,5,5,5},
//				  {10,10,10},
//				  {20,20,20,20},
//				  {30,30}
//				  };
//		System.out.println(arr[3].length);
		
		
		
		/*
		 * [5-3] 배열 arr에 담긴 모든값을 더하는 프로그램을 완성하시오
		 * class Exercise5_3
		 * {
		 * 		public static void main(String[] args)
		 * 		{
		 * 			int[] arr={10, 20, 30, 40, 50};
		 * 			int sum =0;
		 * 
		 * 	(1)알맞은 코드를 넣어 완성하시오
		 * 
		*/
		

//  			int[] arr={10, 20, 30, 40, 50};
//  			int sum =0;
//  			
//  			for(int i=0; i<arr.length; i++) {
//  				sum += arr[i];
//  			}
//  			System.out.println(sum);
		
		
  			
  		
		/*
		 * 2차원 배열 arr 에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
		*/	

//  		int[][] arr = {
//	  			{ 5, 5, 5, 5, 5},
//	  			{10,10,10,10,10},
//	  			{20,20,20,20,20},
//	  			{30,30,30,30,30}
//  			};
//			int total = 0;
//			float average = 0;
//
//			int count = 0;
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < arr[i].length; j++) {
//					total += arr[i][j];
//					count++;
//				}
//			}
//			average = total / count; // arr.length에는 arr[i]의 값인 4가 들어있음
//
//			System.out.println("total=" + total);
//			System.out.println("average=" + average);


  			Scanner sc = new Scanner(System.in);
  			
  			
  			
  			
//  			다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
//  			1~2에 알맞은 코드를 넣어서 프로그램을 완성하시오.
//  			[참고] Math.random()을 사용 했기 때문에 실행결과와 다를 수 있다.
  			
  			
				int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
				int[] ball3 = new int[3];
				
				// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다
				for (int i = 0; i < ballArr.length; i++) {
					int j = (int) (Math.random() * ballArr.length)+1;
					int tmp = 0;
						
					tmp = ballArr[i];
					ballArr[i] = j;
					j = tmp;

					
				}
				

				System.out.println(Arrays.toString(ballArr));
				// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다
				/* (2) */
				for(int i = 0; i < ball3.length; i++) {
					System.out.print(ball3[i]);
				}

  			
  			
  			
  			
	}		
  			
		
}













