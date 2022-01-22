package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 * - 석차구하기: 점수를 비교해 작은 점수의 등수를 증가시키는 방식 (for안의 for, 석차를 저장할 변수만들기)
		 * - 선택정렬: 가장작은 숫자를 찾아서 앞으로 보내는 방식 
		 * - 버블정렬: 바로뒤의 숫자와 비교해서 큰수를 뒤로 보내는 방식
		 * - 삽입정렬: 두번째 숫자부터 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 * 
		*/
	
		
		
		
		//석차구하기
		
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] =(int)(Math.random()*100);
		}
		
//		System.out.println("점수: ");
//		System.out.println(Arrays.toString(arr));
//		
//		//석차구하기
//		int[] rank = new int[arr.length];
//		for(int i=0; i < rank.length; i++) {
//			rank[i] =1;
//		}
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j < arr.length; j++) {
//				if(arr[i] < arr[j]) {
//					rank[i]++;
//				}
//			}
//		}
//		
//		System.out.println("등수: ");
//		System.out.println(Arrays.toString(rank));
		
	
		
		
//		선택정렬		
//		int temp=0;
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<i; j++) {
//				if(arr[i] < arr[j]) {
//					temp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));

		
		
		
		
//		int temp=0;
//		int[] er = new int[10];
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<i; j++) {
//				if(arr[i] < arr[j]) {
//					er[i] = arr[j];
//				}else { er[i] = arr[i]; 
//				}
//				
//				er[i] = arr[j];
//				arr[j] = arr[i];
//				arr[i] = er[i];
//				
//			}
//			
//		}
//		System.out.println(Arrays.toString(arr));
	
		
		
		
		
		//최소값의 위치 찾기

		for(int i=0; i<arr.length-1; i++) { //-1은 마지막까지 갈필요가 없기 때문에 넣는다.
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
					if(arr[min] > arr[j]) {
						min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
		System.out.println(Arrays.toString(arr));
//		
//		
//		
//		//버블정렬
//		//버블정렬: 바로뒤의 숫자와 비교해서 큰수를 뒤로 보내는 방식
//		int[] num = new int[10];
//		for(int i=0; i<num.length; i++) {
//			num[i] = (int)(Math.random()*100);
//		}
//		
//		//start
//		int temp = 0;
//		for(int i=0; i<num.length; i++) { //라운드카운트
//			boolean flag = false; //한번도 돌지 않았을경우 false는 거짓이 된다.
//			for(int j= 0; j<num.length-i-1; j++ ) { //라운드 카운트 전체에서 i회차만큼 뺀 값을 돌린다. 적재
//				if(num[j]>num[j+1]) { //다음값과 비교해서 이전값이 크다면 바꿔준다.  
//					temp = num[j];
//					num[j] = num[j+1];
//					num[j+1] = temp;
//					flag=true;
//				}
//			}
//		if(!flag) {
//			break;//false가 되어 빠져나간다.
//		}
//			
//		}
//		System.out.println(Arrays.toString(num));
		
		
		
		
		//삽입정렬: 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 작은수는 앞으로 넣는다. 

		for(int i=1; i<arr.length; i++) {
			int temp = arr[i]; //i값 보관
			//i증가 j감소
			int j = 0;
			for(j= i-1; j>=0; j--) {
				if(arr[j] > temp) { //작은 값을 만났을때
					arr[j+1]=arr[j]; 
				}else{
					break;
				}
			}
			arr[j+1] =temp;			
		}
		System.out.println(Arrays.toString(arr));
		
		
		//정렬함수
		//System.out.println(Arrays.sort(arr));
		
		
		
		//정확한 표현이 아님
		//내용을 바꾸는것임
//		int temp2 =0;
//		for(int i=1; i<arr.length; i++) {
//			int temp = arr[i]; //i값 보관
//			//i증가 j감소
//			int j = 0;
//			for(j= i-1; j>=0; j--) {
//				if(arr[j] > temp) { //작은 값을 만났을때
//					temp2=arr[j+1];
//					arr[j+1]=arr[j];  
//					arr[j]=temp2;
//				}else{
//					break;
//				}
//			}	
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
	}

}
