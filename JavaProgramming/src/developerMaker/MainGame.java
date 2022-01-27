package developerMaker;

import java.util.Scanner;

import e_oop.ScanUtil;

public class MainGame {

	static int ArbeitCount;
	static int ShoolCount;
	static int HomeCount;
	static int resume;

	MainGame() {
		// 아이템

		Items[] Item = new Items[10];
		Item[0] = new Items("혼자 공부하는 자바책", -5, 10, 5);
		Item[1] = new Items("DB모델링과 오라클책", 0, 10, 10);
		Item[2] = new Items("만화책", 0, 0, -10); // 도서관만 얻을수있게
		// String name, int hp, int intelligent, int stress

		Player play = new Player("대덕이", 50000, 80, 0, 0, true);
		// 이름, 소지금, 체력, 상태, 지능, 스트레스

		// 아르바이트
		Arbeit burgerking = new Arbeit("버거킹", 20000, -10, 0, 10, Item);
		Arbeit mcdonald = new Arbeit("맥도날드", 15000, -5, 0, 5, Item);
		// super(name, money, hp, intelligent, stress, state);
		// 집에 간다(1회차에 스트레스 -10, 체력 +10)
		// 이름, 소지금,hp, 지능, 스트레스

		// 학교
		School lecture = new School("강의실", 0, -10, 10, 10, new Items[] { Item[0], Item[1] });
		School library = new School("도서관", 0, -5, 5, 5, new Items[] { Item[0], Item[1], Item[2] });
		// super(name, money, hp, intelligent, stress);

		// 16회차까지 반복하라
		for (int i = 0; i < 16; i++) {
			play.count++;
			play.printVeiw();

			// 아르바이트 고르기

			if (play.choice == 1) {
				while (true) {
					System.out.print("어떤 아르바이트를 하시겠습니까? [1.버거킹] [2.맥도날드]\t");
					//Scanner sc0 = new Scanner(System.in);
					int scc2 = ScanUtil.nextInt();
					if (scc2 == 1) {
						Arbeit.bonus(play);
						play.ArbeitGo(burgerking);
						break;
					} else if (scc2 == 2) {
						Arbeit.bonus(play);
						play.ArbeitGo(mcdonald);
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
					}

					ArbeitCount++;
				}
			}

			// 학습장소고르기
			if (play.choice == 2) {
				while (true) {
					int Enum = (int) (Math.random() * 100) + 1;
					System.out.print("교내 어느곳으로 이동하시겠습니까? [1.강의실] [2.도서관]\t");
					int scc3 = ScanUtil.nextInt();
					if (scc3 == 1) {
						play.SchoolGo(lecture);
						if (Enum > 1 && Enum < 25) {
							play.intelligent += 10;
							System.out.println("[EVENT] 오늘은 공부가 잘된다! 지능 +10");
						}
						if (Enum > 26 && Enum < 50) {
							play.stress += 10;
							System.out.println("[EVENT] 어제 무리했나...공부가 잘 안된다. 스트레스 +10");
						}
						if (Enum > 51 && Enum < 65) {
							play.itemGet(lecture.itemDrop());
						}
						break;
					}
					else if (scc3 == 2) {
						play.SchoolGo(library);
						if (Enum > 1 && Enum < 25) {
							play.intelligent += 10;
							System.out.println("[EVENT] 오늘은 공부가 잘된다! 지능 +10");
						}
						if (Enum > 26 && Enum < 50) {
							play.stress += 10;
							System.out.println("[EVENT] 어제 무리했나...공부가 잘 안된다. 스트레스 +10");
						}
						if (Enum > 51 && Enum < 65) {
							play.itemGet(library.itemDrop());
						}
						break;
					}
					else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
					}
					ShoolCount++;
				}
			}

			// 집에서 휴식
			if (play.choice == 3) {
				play.HomeGo();
				Home.homeEvent(play);
				HomeCount++;
			}

			play.livingExpenses();

			if (i == 15) {
				// 마지막 회차에 기업에 이력서를 넣는다, 넣지 않는다를 선택할수있다.
				System.out.println("마지막회차까지 플레이 했습니다.\n이력서를 넣으시겠습니까? 넣는다[1] / 넣지않는다 [2]");
				while(true) {
					resume = ScanUtil.nextInt();
						if(resume == 1 || resume == 2) {
							play.money = play.money < 0 ? 0 : play.money;
							play.money = play.money > 100 ? 100 : play.money;
							// 엔딩
							Ending.ending(play);
							break;
							}else {
								System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.>");
							}
				}

			}

		}

	}

	public static void main(String[] args) {

		new MainGame();

		// 소지금이 0이면 무조건 아르바이트를 해야한다.
		// 체력이 0이면 무조건 휴식(집)해야한다.
		// 스트레스가 80이상, 체력이 20이하이면 상태가 아픔(false)으로 바뀐다.
		// 매일 생활비로 일주일에 -10000이 소비된다.
		// 마지막 회차에 기업에 이력서를 넣는다, 넣지 않는다를 선택할수있다.

		// 배경을 총 4개월로 일주일을 1번의 선택지로 본다.
		// 따라서 게임은 16번 진행된다.

		// 화면표시 출력
		// 선택1,2,3(소지금,체력 조건)
		// 선택 1일때
		// 선택 2일때 필수출력, 확률체크
		// 선택 3일때 필수출력, 확률체크
		// 상태체크(스트레스,체력)
		// 생활비로 -10000소비
		// 마지막회차에 기업이력서 선택지

		// 엔딩

	}

}
