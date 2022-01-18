package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * 다차원배열
		 * - 배열안에 배열이 저장되어있는 형태이다.
		 * 
		*/
		
		//대괄호 갯수를 늘리면 n차원 배열이 된다.
		//2차원
		int[][] array2;
		
		//3차원
		int[][][] array3;
		
		///////////////////////////////////
		
		//2차원 배열만들기
		int[][] arr=new int[2][3];  //1차원이 길이: 2, 2차원의 길이: 3
		
		/*
		 * 변수 = 100번지 (주소)
		 * 
		 * 100번지
		 * {200번지, 300번지}
		 * 		
		 * 200번지
		 * {0, 0, 0}
		 * 
		 * 300번지
		 * {0, 0, 0}
		 * 
		*/		
		
		int arr2[][] = new int[][] {{1,2,3},{4,5,6}};
		int[] arr3[] = {{1,2,3},{4,5,6},{7,8,9}};
		
		//다차원배열
		int[][] arr4 = new int[3][]; //가변배열, 2차원배열을 그때마다 만들어서 사용해야함
		//ex)
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];
		
		
		// arr[0] = 10; --2차원에는 값이 저장되야함.
		arr[0] =new int[5]; //1차원은 배열을 저장하는 곳이다.
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;
		
		
//		System.out.println(arr[0][1]);
		
		
		
//		System.out.println(arr.length); //1차원의 길이
//		System.out.println(arr[0].length); //2차원의 길이
//
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				System.out.println(i+","+j+","+arr[i][j]);
//			}
//		}
		
		
		
		int[][] scores =new int[3][5]; //학생수 과목수
		int[] sum = new int[scores.length]; //합계
		double[] avg = new double[scores.length]; //평균
		
		//0~100까지의 랜덤한 수를 저장
		//각학생의 합계와 평균을 저장한다.
		
		
		//
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				scores[i][j] =(int)(Math.random()*100);
					System.out.println(i+","+j+","+scores[i][j]);
			}
		}
		
		int count = 0;
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				sum[i] = sum[i] + scores[i][j];
				count++;
			 }
			avg[i] =  (double)sum[i]/count;
		}
		
		
		
		System.out.println("합계:"+Arrays.toString(sum));
		System.out.println("평균:"+Arrays.toString(avg));
		
		
		
	}
}

