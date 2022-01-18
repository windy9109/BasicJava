package test;

public class Test {

	public static void main(String[] args) {
		
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100사이의 랜덤한 점수로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 이름		국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */
		
		//이름을 저장할 1차원 배열 선언
		String[] name = {"홍길동1","홍길동2","홍길동3","홍길동4","홍길동5","홍길동6","홍길동7",
					"홍길동8","홍길동9","홍길동10","홍길동11","홍길동12","홍길동13","홍길동13",
					"홍길동14","홍길동15","홍길동16","홍길동17","홍길동18","홍길동19","홍길동20","홍길동21",
					"홍길동22","홍길동23","홍길동24","홍길동25"};
		//과목을 저장할 1차원 배열 선언
		String[] subjects = {"국어","영어","수학","사회","과학","Oracle","Java"};
		
		//2차원배열선언
		int[][] score = new int[name.length][subjects.length];

		
		//배열에 랜덤값 삽입
		for(int i=0; i<score.length; i++ ) {
			for(int j=0; j<score[i].length; j++) {
			score[i][j] = (int)(Math.random()*101);
			}
		}
		
		int[] nameSum = new int[score.length];
		int[] nameAvg = new int[score.length];
		//학생별(행별) 성적 합계,평균
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				nameSum[i] += score[i][j];
			}
			//nameAvg[i]= Math.round((double)nameSum[i]/score.length*100)/100.0;
		}
		
		
		
		
		
		
		
		
		

	}

}
