package j_collection;

import java.util.ArrayList;



public class Score {

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
		
		//25명의 성적을 랜덤으로 넣고 정렬하여 출력한다.
		//합계평균산출 과목별, 학생별 합계평균 산출
		
		//석차출력
		//석차 정렬
		
		
		
//		ArrayList<Name> name2 = new ArrayList<Name>();
//		name2.add(new Name("홍1","홍2","홍3","홍4","홍5","홍6","홍7","홍8","홍9",
//				"홍10","홍11","홍12","홍13","홍14","홍15","홍16","홍17","홍18","홍19",
//				"홍20","홍21","홍22","홍23","홍24","홍25"));
//		System.out.println(name2);
		
//		for(int i=0; i<25; i++) {
//			name.
//			for(int j=0; j<7; j++) {
//				
//			}
//		}
		
		ArrayList<String> name = new ArrayList<String>();
		for(int i=1; i<26; i++) {
			name.add("홍길동"+i);
		}
		

		ArrayList<String> sujname = new ArrayList<String>();
		sujname.add("국어");
		sujname.add("영어");
		sujname.add("수학");
		sujname.add("사회");
		sujname.add("과학");
		sujname.add("Oracle");
		sujname.add("Java");
		
		
		ArrayList<ArrayList<Integer>> score = new ArrayList<ArrayList<Integer>>();
		
		//스코어에 랜덤한 점수넣기
		for(int i=0; i<name.size(); i++) {
			score.add(new ArrayList<Integer>());
			for(int j=0; j<sujname.size(); j++) {
				score.get(i).add((int)(Math.random()*101));
			}
			
		}

		ArrayList<Integer> stsums = new ArrayList<Integer>();
		ArrayList<Double> stavgs = new ArrayList<Double>();
		
		//학생점수
		for(int i =0; i<score.size(); i++) {
			int stsum =0;
			for(int j=0; j<score.get(i).size(); j++) {
				stsum += score.get(i).get(j);
			}
			stsums.add(stsum);
			stavgs.add(Math.round(((double)stsum/score.get(i).size())*100)/100.0);
		}
		
		ArrayList<Integer> sjsums = new ArrayList<Integer>();
		ArrayList<Double> sjavgs = new ArrayList<Double>();
		
		//과목 합계평균
		for(int i=0; i<sujname.size(); i++){
			int sjsum =0;
			for(int j=0; j<name.size(); j++) {
				sjsum += score.get(j).get(i);
			}
			sjsums.add(sjsum);
			sjavgs.add(Math.round(((double)sjsum/sujname.size())*100)/100.00);
		}
		
	//	System.out.println(stavgs);
		
		//석차
		ArrayList<Integer> rank = new ArrayList<Integer>();
		
		for(int i=0; i<name.size(); i++) {
			rank.add(1);
		}
		
		for(int i=0; i<rank.size(); i++) {
			for(int j=0; j<rank.size(); j++) {
				if(stsums.get(i) < stsums.get(j) ) {
					rank.set(i,rank.get(i)+1);
				}
			}
		}
		
		
		for(int i=0; i<rank.size(); i++) {
			int min = i;
			for(int j=i+1; j<rank.size(); j++) {
				if(rank.get(j) < rank.get(min)) {
					min = j;
				}	
		  }
			name.set(i,name.set(min,name.get(i)));
			score.set(i,score.set(min,score.get(i)));
			stsums.set(i,stsums.set(min,stsums.get(i)));
			stavgs.set(i,stavgs.set(min,stavgs.get(i)));
			rank.set(i,rank.set(min,rank.get(i)));
		}
	

		
		
		
		
		System.out.print("이름\t");
		for(int i=0; i<sujname.size(); i++) {
			System.out.print(sujname.get(i)+"\t");
		}
		System.out.println("합계\t평균\t석차");
		
		for(int i=0; i<score.size(); i++) {
			System.out.print(name.get(i)+"\t");
			for(int j=0; j<score.get(i).size(); j++) {
			System.out.print(score.get(i).get(j)+"\t");
			}
			System.out.println(stsums.get(i)+"\t"+stavgs.get(i)+"\t"+rank.get(i)+"\t");	
		}
		
		System.out.print("과목합계\t");
		for(int i=0; i<sjsums.size();i++) {
			System.out.print(sjsums.get(i)+"\t");
		}
		System.out.print("\n과목평균\t");
		for(int i=0; i<sjsums.size();i++) {
			System.out.print(sjavgs.get(i)+"\t");
		}

	}



}



