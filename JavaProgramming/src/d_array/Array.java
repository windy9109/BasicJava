package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열 
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 * 
		*/
	
		//배열 선언방법1
		int[] array; //배열의 주소를 저장할 공간이 만들어진다. 타입뒤에 붙여서 많이 사용함.
		array = new int[5]; //배열이 생성되고 그 주소가 저장된다.
		//기본값이 저장된다.
		
		/*
		 * 변수 =100번지(주소)
		 * 
		 * 100번지
		 * {0, 0, 0, 0, 0}
		 * 
		*/
		
		//배열 선언방법2
		array = new int[] {1,2,3,4,5}; //대괄호에 값X, 중괄호 값O
		//array = {1,2,3,4,5}; --오류
		
		//배열 선언방법3
		int[] array2 = {1,2,3,4,5}; //변수 선언과 초기화를 동시에 해준다.
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		
		//배열의 인덱스를 정하지 않고 출력 할 경우 [I@75a1cd57와 같이 배열주소가 출력
		System.out.println(array); 
		
		
		//인덱스배열 출력
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		
		//array.length 배열의 길이
		//array.length를 사용한 코드가 더 좋다.
		for(int i=0; i < array.length; i++) {
			array[i] = (i+1)*10;
		}
		
		for(int i =0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		
		System.out.println();
		
		
		
		
		//문제1. 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		
		//int[] array1 = {1,2,3,4,5,6,7,8,9,10};
		int[] array1= new int[10];
		

		
		
		//배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		
		for(int i=0; i < array1.length; i++) {
			array1[i] = (int)(Math.random()*100)+1;
			System.out.println(array1[i]);
		}
		
		
		
		System.out.println(Arrays.toString(array1)); //Arrays.toString() 배열안의 숫자 출력
		// sysout + ctrl + 스페이스 > 자동완성
		
		
		System.out.println();
		
		
		//배열에 저장된 모든값의 합계와 평균을 출력해주세요.
		int sum=0;
		
		for(int i=0; i< array1.length; i++) {
			sum = sum + array1[i];
		}
		double avg = (double)sum/array1.length; 
		//소숫점을 구하자 int를 double으로 바꾸기 위해서는 두값중하나가 double여야 함
		
		System.out.println("합계: "+sum);
		System.out.println("평균: "+avg);
		
		System.out.println();
		
		
		
		
		
		
		
		//배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		//최소값을 저장할 변수를 만들고 배열의 첫번째 값을 저장한다.
		//최대값을 저장할 변수를 만들고 배열의 첫번째 값을 저장한다.
		//변수에 저장된 값과 배열의 모든 인덱스의 값을 비교하기 위한 for문을 만든다.
		//최소값이 저장된 변수와 배열의 값을 비교해서 더 작은 값을 찾으면 변수에 자장한다.
		//최대값이 저장된 변수와 배열의 값을 비교해서 더 큰 값을 찾으면 변수에 저장한다.
		
		
		
		
		//if문으로 풀기
		int max= 0;
		int min= 100;
		
		for(int i=0; i < array1.length; i++) {
			if(array1[i]>max) {
				 max = array1[i];
			}
			if(array1[i]<min) {
				min = array1[i];
			}
			// max = array1[i] > max;  비교연산시 참,거짓으로 boolean값으로 받게된다. 따라서 int자료형인 변수에 저장할수 없다.
			// min = array1[i] < min;
		}
		System.out.println("max: "+max);
		System.out.println("min: "+min);
		System.out.println();
		
		
		
		
		
		
		
		//삼항연산으로 풀기
		int min1=100;
		int max1=0;
		for(int i=0; i < array1.length; i++) {
			max1 = array1[i] > max1? max1=array1[i]: max1;
			min1 =array1[i] < min1? min1=array1[i]: min1;
		}
		System.out.println("max1: "+max1);
		System.out.println("min1: "+min1);
		
		
		
		System.out.println();
		
		
		
		
		
		
		//배열의 값을 섞어주세요.
		//랜덤한 index를 발생시켜서 0번 index와 자리를 여러번 바꾼다.
		
		
		int[] shuffle = new int[10];
		for(int i=0; i<shuffle.length; i++) {
			shuffle[i] = i+1;
		}
		
		int[] random1= new int[10];
		for(int i=0; i < random1.length; i++) {
			random1[i] = (int)(Math.random()*10)+1;
			System.out.println(array1[i]);
		}
		
		int temp =0;
		
		for(int i=0; i < random1.length; i++ ) {
			temp = shuffle[0];
			shuffle[0] = random1[i];
			random1[i] = temp;
		}
	
		
	
		System.out.println(Arrays.toString(shuffle));
		System.out.println(Arrays.toString(random1));	
	

		
		
		
		
	
		
//		int[] shuffle0 = new int[10];
//		for(int i=0; i<shuffle0.length; i++) {
//			
//			int random0 =(int)(Math.random()*10)+1;
//			int temp0= shuffle0[random0];
//			
//		}
		
		
		
		//1~10 사이의 랜덤한 값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		
		//숫자카운트
		int[] count0 = new int[10];
		
		for(int i=0; i<500; i++) {
			int random00 = (int)(Math.random()*10)+1;
//			if(random == 1) {
			count0[random00-1]++; //생성된 숫자 -1로 배열의 주소를 찾아가서 ++1 저장함		
		}
		
		System.out.println(Arrays.toString(count0));
		
		
		
		
		
		
		
		
	}

}










