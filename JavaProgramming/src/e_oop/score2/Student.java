package e_oop.score2;

import e_oop.score2.Student;

public class Student {

	//변수선언
	String name;
	int kor;
	int eng;
	int math;
	double avg;
	int rank =1;
	
//	int stsum= kor + eng + math; 
//	double stavg = Math.round(stsum/3.0*100)/100.0;
	
	
	
	//점수랜덤생성
	int sum;
	void randomScore() {
		kor = (int)(Math.random()*101);
		eng = (int)(Math.random()*101);
		math = (int)(Math.random()*101);
	} 
	
	//합계
	int getSum() {
		return sum = kor+eng+math;
	}
	
	//평균
	double getAverage() {
		return avg = Math.round(getSum()/3.0*100)/100.0;
	}
	
	int getRank(Student[] students) {
		rank=1;
		for(int i=0; i<students.length; i++) {
			if(getSum()<students[i].getSum()) {
				rank++;
				
			}
		}
		return rank;
	}
	
	
	//데이터제공 메서드
	String getInfo() {
		return name +"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+avg+"\t"+rank+"\t";
	}
	
	
}
