package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStyudent {

  public static void main(String[] args) {
	/*
	 * 25칸짜리 문자열을 저장할수있는 배열을 만든뒤 저장한다. 그중에서 랜덤으로 몇명을 뽑는다. 뽑을때는 사용자에게 명수를 입력을 받는다.
	 * 중복이 되면 안된다 
	 * 
	 */

	// List
	String[] name = new String[] { "김1", "김2", "김3", "김4", "김5", "이1", "이2", "이3", "이4", "이5", "박1", "박2", "박3",
			"박4", "박5", "박6", "박7", "박8", "박9", "박10", "윤1", "윤2", "윤3", "윤4", "윤5" };
	System.out.println("1~25사이의 숫자를 입력해주세요");

	//중복제거가 핵심
	// 사용자에게 명수를 입력받는다
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();

	
	// 1~25까지 랜덤한 숫자배열을 만든다.
	int[] src = new int[num];
	/*
	 * for(int i=0; i < src.length; i++) { src[i] = (int)(Math.random()*24);
	 * System.out.println(src[i]); }
	 */

	for (int i = 0; i < num; i++) {
		// 랜덤한 숫자25개를 생성한다.
		src[i] = (int) (Math.random() * 25); //Math.random() * (최댓값(24)-최소값(0)+1) + 최소값(0)은 0~23까지의 수
		//(int)(Math.random()*(24-1+1))
		//(int)(Math.random()*24-0+0)+0
		
		//해당수식에 +1을 더하면 난수의 생성범위는 1~25가 된다.
		//(int)(Math.random()*24)로 연산한다면 0~24사이의 값을 말한다.
		
		//
		//(int)(Math.random()*13)+12 라고한다면 
		//최대값 13+12=25, 최소값 12 -> 12~25사이의 값

		for (int j = 0; j < i; j++) {
			if (src[i] == src[j]) {
				i--;
			}
		}

	}
	for (int i = 0; i < num; i++) { //num 만큼 반복한다.
		System.out.println(name[src[i]]); //중복되지 않은 난수의 배열 src[i]에서 값을 받아온 뒤 
	}

//			System.out.println(name[random]);

  }

}
