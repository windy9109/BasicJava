package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 
		 * 135: 1S 1B 1O
		 * 379:0S 0B 3O
		 * 스트라이크/볼/아웃
		 * 야구게임 만들기 
		 * 
		*/
		
		//1~9사이의 랜덤한 세개의 숫자 생성(중복X)
		int random1=0;
		int random2=0;
		int random3=0;

		while(random1 == random2 || random1 == random3 || random2 == random3 ) {
			random1 = (int)(Math.random()*9)+1;
			random2 = (int)(Math.random()*9)+1;
			random3 = (int)(Math.random()*9)+1;
		}
		
		
		int count = 0;
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============================================");
		System.out.println("                 GAME START                 ");
		
		

		
		
		outer: while(true){
			
			//스코어 저장
			int S=0;
			int B=0;
			int O =0;
			
			System.out.println("============================================");
			System.out.println("숫자 세자리를 입력해주세요.");
			int num = Integer.parseInt(sc.nextLine()); 
			//num값을 각각의 n1, n2, n3에 저장함
			

			
			int n1 = num/100;
			int n2 = num/10%10;
			int n3 = num%10;
			

			//S스코어
			if(n1 == random1) { S++; }
			if(n2 == random2) { S++; }
			if(n3 == random3) { S++; }
			
			//B스코어
			if(n1 == random2) { B++; }
			if(n1 == random3) { B++; }
			if(n2 == random1) { B++; }
			if(n2 == random3) { B++; }
			if(n3 == random1) { B++; }
			if(n3 == random2) { B++; }
			
			//O스코어: S와 B를 더한 값에서 3을 뺀값
			O = (3-(S+B));

			System.out.println( "정답 :"+random1+""+random2+""+random3 );
			System.out.print( "스코어: S"+S+" B"+B+" O"+O );
			
			
			//3스트라이크 일 경우 outer: While을 빠져나감
			if(S == 3) {
				System.out.println( "\n::::::::::: 정답입니다. 게임이 끝났습니다 :::::::::::" );
				break outer;
			}
			
			//3스트라이크가 아닐시 S,B,O 초기화 후 재게임
			System.out.println("\n"+ ++count+"차 시도! 아쉽네요! 재도전!" );

				
		}
		
	}

}
