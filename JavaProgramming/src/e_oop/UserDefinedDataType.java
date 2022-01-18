package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		
		/*
		 * 사용자 정의 데이터 타입
		 * - 데이터의 최종진화 형태이다.(기본형 -> 배열 -> 클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 * - 변수와 메서드로 구성할 수 있다.
		 * 
		*/
		
		
		//기본형
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		
		//배열
		int[] scores;
		int sum2;
		double avg2;
		
		
		//클래스
		Student student = new Student(); //객체생성(인스턴스화)
		//클랙스의 이름이 타입화됨
		
		student.kor =(int)(Math.random()*101); //국어점수 랜덤발생
		student.eng =(int)(Math.random()*101); //영어점수 랜덤발생
		student.math =(int)(Math.random()*101); //수학점수 랜덤발생
		student.sum = student.kor + student.eng + student.math;
		student.avg = Math.round(student.sum/3.0*100)/100.0;
		
		System.out.println("합계: "+student.sum);
		System.out.println("평균: "+student.avg);
		
	}

}





//클래스 안에서 변수선언
class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
}









