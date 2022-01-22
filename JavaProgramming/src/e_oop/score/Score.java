package e_oop.score;

public class Score {

	

	public static void main(String[] args) {
		
		
		String[] studentNames = {"김기웅","박태정","이정규","오지현"};
		String[] subjectname = {"국어","영어","수학"};
		Student[] students = new Student[studentNames.length];
		Student students2 = new Student();
		
		
		for(int i=0; i< students.length; i++) {
			students[i] = new Student();
			students[i].name = studentNames[i];
		}
		
		
		//프로그램을 완성해주세요. 
		
		
		//학생 합계 평균
		//전역변수
		
		
		int[] sjsum= new int[subjectname.length];
		double[] sjavg= new double[subjectname.length];
		
		//과목 합계 평균
		//과목 합부분 다시작성 
		for(int i=0; i<studentNames.length; i++) {
			sjsum[0] += students[i].kor;
			sjsum[1] += students[i].eng;
			sjsum[2] += students[i].math;

		}

		for(int i=0; i<subjectname.length; i++) {
			sjavg[i] = Math.round(sjsum[i]/studentNames.length*100)/100.0;
		}
		
		
		
		
		//석차
		for(int i=0; i<studentNames.length; i++) {
			for(int j=0; j<studentNames.length; j++) {
				if( students[i].stsum < students[j].stsum ) {
					students[i].rank++;
					
				}
			}
			
		}
		
		//정렬

		for(int i=0; i<students.length; i++) {
			int min =i;
			for(int j=i+1; j<studentNames.length; j++) {
				if( students[j].rank < students[min].rank ) {
					min = j;
					
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
		
		
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		for(int i =0; i<studentNames.length; i++) {
			System.out.print(studentNames[i]+"\t"
							+students[i].kor+"\t"
							+students[i].eng+"\t"
							+students[i].math+"\t"
							+students[i].stsum+"\t"
							+students[i].stavg+"\t"
							+students[i].rank+"\t\n"
					);
		}
		
		

		
		System.out.print("과목합계:\t");
		for(int i=0; i<subjectname.length; i++) {
			System.out.print(sjsum[i]+"\t");
		}
		System.out.println();
		System.out.print("과목평균:\t");
		for(int i=0; i<subjectname.length; i++) {
			System.out.print(sjavg[i]+"\t");
		}
		
		
		
		
		
	}

}
