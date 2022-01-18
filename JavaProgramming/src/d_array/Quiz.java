package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		
//		int money =(int)(Math.random()*500)*10;
//		int[] coin = {500,100, 50, 10};
//		int[] bin = new int[money];
//		int[] bin2 = new int[money];
//			System.out.println("거스름돈:"+money);
		/*
		 * 
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 
		 * <출력화면>
		 * 거스름돈: 2860원
		 * 500원: 5개
		 * 100원: 3개
		 * 50원: 1개
		 * 10원: 1개
		 * 
		 * 		
		*/
			
//			for(int i=0; i<coin.length; i++) {
//				bin[i] = money/coin[i];
//				for(int j=0; j == 0; j++) {
//					bin2[i] = money%coin[i];
//					money = bin2[i];
//				}
//				System.out.println(coin[i]+"원: "+bin[i]+"개");
//			}
			

			
			int[] arr = new int [20];
			int[] arr2 = new int [5];
			for(int i=0; i<arr.length; i++) {
				arr[i] = (int)(Math.random()*5)+1;
			}
//			System.out.println(Arrays.toString(arr));
			
			/*
			 * 1~5사이의 숫자가 발생된 횟수 만큼 *을 사용해 그래프를 그려주세요
			 * 
			 * 1: ***3
			 * 2: ****4
			 * 3: **2
			 * 4: ****4
			 * 			
			*/			
			String star="*";
			int num = 0;
			for(int i=0; i<5; i++) {
				for(int j=0; j<arr.length; j++) {
					if(i+1 == arr[j]) {
						arr2[i]++;
					} 
				}
				
			}
			
		
			
		System.out.println("랜덤한 20개");
   	 	System.out.println(Arrays.toString(arr));
   	 	System.out.println("카운트");
   	 	System.out.println(Arrays.toString(arr2));
///////////////////////////////////////////////////////
   	 	
   	 	for(int i=0; i<arr2.length; i++) {
   	 		System.out.print(i+1 +": ");
   	 		for(int j=0; j<arr2[i]; j++ ) {
   	 			System.out.print(star);
   	 		}
   	   	 	System.out.println(" "+arr2[i]);
   	 	}

  
   	 	
   	 	
   	 	
   	 	
   	 	
   	 	
   	 	
   	 	
   	 	
			
			
	}

}






