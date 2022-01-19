package e_oop.score;

public class Student {

	

	

	
	
	String name;
	int kor=(int)(Math.random()*101);
	int eng=(int)(Math.random()*101);
	int math=(int)(Math.random()*101);
	double avg;
	int rank =1;
	
	int stsum= kor + eng + math;
	double stavg = Math.round(stsum/3.0*100)/100.0;
	

	
	
	
//	
//	void print() {
//		
//	for(int i=0; i<4; i++) {
//		System.out.print(kor+"\t");
//		System.out.print(eng+"\t");
//		System.out.print(math+"\t");
//		System.out.print(stsum+"\t");
//		System.out.print(stavg+"\t");
//		System.out.print(rank+"\t");
//		System.out.println();
//	}
//		
//	}

	
	
	
	
	//전역변수는 초기화 하지 않아도 자동으로 초기화된다.
	//지역변수는 직접 해줘야함
	//
	

}
