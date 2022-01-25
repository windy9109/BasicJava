package developerMaker;

import java.util.Scanner;

public class MainGame {
	
			MainGame(){
				Player play = new Player("대덕이", 50000, 80, 0, 0, true); 
				//이름, 소지금, 체력, 상태, 지능, 스트레스
				
				//아르바이트
				Arbeit arbe1 = new Arbeit("버거킹", 20000, -10, 0, 10);
				Arbeit arbe2 = new Arbeit("맥도날드", 15000, -5, 0, 5);
				//이름, 소지금,hp, 지능, 스트레스
				
				
				
				
				//16회차까지 반복하라
				for(int i=0; i<16; i++) {
					play.count++;
					play.printVeiw();
					
					
					//아르바이트 고르기
					if( play.choice == 1 ) {
						System.out.print("어떤 아르바이트를 하시겠습니까? [1.버거킹] [2.맥도날드]\t");
						Scanner sc0 = new Scanner(System.in);
						int scc2 = Integer.parseInt(sc0.nextLine());
						if(scc2 == 1) {
							play.ArbeitGo(arbe1);
						}else if(scc2 == 2){
							play.ArbeitGo(arbe2);
						}
						Arbeit.bonus(play);
					}
					
					//학습장소고르기
					if( play.choice == 2 ) {
						System.out.print("교내 어느곳으로 이동하시겠습니까? [1.강의실] [2.도서관]\t");
						Scanner sc0 = new Scanner(System.in);
						int scc2 = Integer.parseInt(sc0.nextLine());
						if(scc2 == 1) {
							play.ArbeitGo(arbe1);
						}else if(scc2 == 2){
							play.ArbeitGo(arbe2);
						}
					}
					
					
					
					
					System.out.println("생활비로 10000원이 지출되었습니다.\n\n");
					
				
				
					
					
					if(i == 15) {
						//마지막 회차에 기업에 이력서를 넣는다, 넣지 않는다를 선택할수있다.
						play.resume();
						
					}
					
				}
				
				
			}
			



	public static void main(String[] args) {
		
		
		//소지금이 0이면 무조건 아르바이트를 해야한다.
		//체력이 0이면 무조건 휴식(집)해야한다.
		//스트레스가 80이상, 체력이 20이하이면 상태가 아픔(false)으로 바뀐다.
		//매일 생활비로 일주일에 -10000이 소비된다.
		//마지막 회차에 기업에 이력서를 넣는다, 넣지 않는다를 선택할수있다.


		
		//배경을 총 4개월로 일주일을 1번의 선택지로 본다.
		//따라서 게임은 16번 진행된다.
		
		new MainGame();
		
		
		
		//화면표시 출력
		//선택1,2,3(소지금,체력 조건)
		//선택 1일때 
		//선택 2일때 필수출력, 확률체크
		//선택 3일때 필수출력, 확률체크
		//상태체크(스트레스,체력)
		//생활비로 -10000소비
		//마지막회차에 기업이력서 선택지
		
		//엔딩
		
		
	}

}
