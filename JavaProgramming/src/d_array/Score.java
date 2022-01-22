package d_array;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		
		/*
		 *우리반 모두의 국어, 영어, 수학, 사회, 과학, oracle, java 점수를 출력해주세요
		 *0~100반 사이의 랜덤한 정수로 생성해주시고. 아래와 같이 출력해주세요.
		 *
		 *이름  		국어	  영어  	수학 	 	사회		과학 		Oracle 		java 	합계 		평균 		석차
		 *홍길동 		90
		 *홍길동		90 
		 *홍길동		90
		 *홍길동		90
		 *홍길동		90
		 *과목합계		450
		 *과목평균	   90.00
		 * 
		 * 		
		*/
		
		//학생별 과목점수를 저장할 배열
		int[][] score = new int[5][7]; //학생수, 과목수
		
		//과목명
		String[] title= {"이름","국어","영어","수학","사회","과학","oracle","java","합계","평균","석차"};
	
		//학생명
		String[] row= {"홍길동","이정민","민지혜","장영란","박지성"};
		
		
		//전과목 랜덤한 성적넣기
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				score[i][j] =(int)(Math.random()*100);
	//			System.out.print(+i+","+j+","+score[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		//과목별 합계와 평균
		int[] sjsum = new int[7];
		double[] sjavg = new double[7];
		//학생별 합계와 평균
		int[] stsum = new int[5];
		double[] stavg = new double[5];
		
		
		
		//학생별 합계,평균
		for(int i=0; i<score.length; i++ ) {
			for(int j=0; j<score[i].length; j++) {
				stsum[i] = stsum[i] + score[i][j];
			}
			stavg[i] = Math.round((double)stsum[i]/score[i].length);
		}
		

		
		//과목별 합계,평균
		for(int i=0; i<sjsum.length; i++ ) { //합한 과목을 평균내어 출력한다
			for(int j=0; j<stsum.length; j++) { //학생수 만큼 돌린다(합계산출)
				sjsum[i] = sjsum[i] + score[j][i];
			}
			sjavg[i] =Math.round((double)sjsum[i]/stsum.length); 
			// (학생수/과목합계) = 과목평균 
		}
		
		
		
		
		
		
		
		//개별성적 String 형변환
//		String[][] score2 = new String[5][7];
//		for(int i=0; i<score2.length; i++ ) {
//			for(int j=0; j<score2[i].length; j++) {
//				score2[i][j] = String.valueOf(score[i][j]);
//			}
//		}
		
		
		
		//학생이름과 성적 한묶음으로
//		String[][] emp = new String[5][8];
//		for(int i=0; i<emp.length; i++) {
//
//			for(int j=0; j<emp.length; j++) {
//				if( j == 0 ) {
//					emp[i][j] = row[i];
//						break;
//				}
//				if(j !=0 ) {
//					emp[i][j] = score2[i][j];
//				}
//			}
//		}
//		

		
		
		//석차구하기
		int[] rank = new int[stsum.length]; //학생수만큼의 배열크기
		
		//1로 초기화
		for(int i=0; i<stsum.length; i++) { 
		 rank[i] = 1; //모든 자리에 1을 넣는다
		}
		
		for(int i=0; i<rank.length; i++) {  //학생수만큼 출력
			for(int j=0; j<stsum.length; j++) {  //비교할 점수만큼 출력
				if(stsum[i]<stsum[j]) {  //다음학생이 이전학생보다 점수가 클경우
					rank[i]++;   //현재학생의 랭크의 숫자가 커진다
				}
			}
		}
		//최종에는 rank[i]++; 되지 않은 학생이 1등으로 출력됨
		
		
		
		
		
		
		
		//상단 출력문(성적출력)
		for(int i=0; i<title.length; i++) {
			System.out.print(title[i] + "\t");
		}
		
		System.out.println();
		for(int i=0; i<score.length; i++) {
			System.out.print("\n"+row[i]+"\t" );
			for(int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.print(stsum[i]+"\t");
			System.out.print(stavg[i]+"\t");
			System.out.print(rank[i]+"\t");
		}
		
		
		 
		//하단 출력문

		System.out.println("");

		//과목 합계, 평균 배열에 넣고 출력
		double[][] total= new double [2][7];

		System.out.println();
			for(int i=0; i<2; i++ ) {
				if(i==0) {
					System.out.print("과목합계\t");
				for(int j=0; j<sjsum.length; j++ ) {	
						total[i][j] = sjsum[j];
						System.out.print((int)total[i][j]+"\t");
						
					  }
				}
				System.out.println();
				if(i==1) {
					System.out.print("과목평균\t");
					for(int j=0; j<sjavg.length; j++ ) {	
							total[i][j] = sjavg[j];
							System.out.print(total[i][j]+"\t");
						  }
					}
				
			}
			
				
//			System.out.println("과목합계");
//			System.out.println("과목평균");
//			System.out.println();
//				

				
//			for(int i=0; i<total.length; i++) {
//				if(i == 0) {
//					for(int j=0; j<total[i].length; j++) {
//						System.out.println((int)total[i][j]);
//					}
//				}
//				if(i == 0) {
//					for(int j=0; j<total[i].length; j++) {
//						System.out.println(total[i][j]);
//					}
//				}
//				
//			}
				
				
				
//				for(int i=0; i<sjsum.length; i++ ) {
//					System.out.print(sjavg[i]+"\t");
//				}
			
		System.out.println();
		
	
		
		
//		System.out.println(Arrays.toString(sjsum));
//		System.out.println(Arrays.toString(sjavg));
		
		
//		System.out.println(Arrays.toString(score[i][j]));
//		System.out.println(Arrays.toString(sjtotal[i][j]));
//		System.out.println(Arrays.toString(sttotal[i][j]));
//		
		
		
		
		
//		for() {
//			
//		}
//		
//		//학생별 합계 
//		//학생별 평군
//				
//		for() {
//			
//			
//		}
		
		
		
		
	}

}
