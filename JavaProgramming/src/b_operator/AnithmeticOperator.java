package b_operator;

public class AnithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술 연산자 
		 * -사칙연산: +, -, *, /, %(나머지)
		 * -복합연산: +=, -=, *=, /=, %=
		 * -증감연산: ++, --
		 * 
		*/
		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
		result = 10 / 3;
		System.out.println(result);
		
		result = 10 % 3; //나머지(홀짝 구분시)
		System.out.println(result+"\n");
		
		
		
		//5개의 산술연산자를 이용해 사칙연산을 수행 후 결과를 출력해주세요.
		int x1= 100+321;
		int x2= 100-321;
		int x3= 100*321;
		int x4= 100/321;
		int x5= 100%321;
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x4);
		System.out.println(x5);
		
		
		//복합연산
		result = result + 3;
		result += 3;		
		result -= 5;
		result *= 2;
		result /= 3;
		result -= 3 + 2; //우측의 3+2 연산 먼서 수행후 -=연산자 수행됨
		
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		//result = result + 10
		//result = result % 5;
		//result = result - 2 * 3;
		
		result += 10;
		result %= 5;
		result -= 2*3;
		
		
		//증감연산
		//증가연산자(++) : 변수의 값을 1 증가시킨다.
		//감소연산자(--) : 변수의 값을 1 감소시킨다.
		
		int i =0;
		++i; //전위형: 변수의 값을 읽어오기 전에 1 증가된다
		i++; //후위형: 변수의 값을 읽어온 후에 1 증가된다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i"+ ++i);
		i=0;
		System.out.println("i++"+ i++);
		System.out.println("i");
		
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double redult2 = _int + _double; //묵시적 형변환 
		//double redult2 = (double)_int + _double;과 같다
		
		System.out.println(redult2);
		
		
		byte _byte=5; //최소 4byte크기 이상이여야만 연산함.
		short _short =10;
		_int = _byte + _short; //int보다 작은 타입의 자료형은 int로 자동 형변환 후 계산된다.
		
		
		char _char = 'a'; //아스키코드 97 
		char _char2 = 'b'; //아스키코드 98
		_int = _char+_char2; //char: 2byte 이므로 int로 형변환 됨.
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할때 발생하는 현상
		
		byte b = 127; //byte에서 표현할수 있는 가장 큰값 127
		b++; //++로 128이 됨
		System.out.println(b); //출력결과: -128 -> 오버플로우
		b--;
		System.out.println(b); //출력결과: 127 -> 언더플로우
		
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456+654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
		double q1 = 123456 + 654321;
		q1 *= 123456;
		q1 /= 123456;
		q1 -= 654321;
		q1 %= 123456;
		
		System.out.println("\n\n\n"+q1+"\n\n\n");
		
		/*
		 * int q0 = 123456+654321* 123456; System.out.println(q0);
		 */
		
		
		
		//3개의 int타입 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int w1 = 15;
		int w2 = 34;
		int w3 = 49;
		int sum = w1 + w2 + w3;
		double avg = sum / 3.0; // double사용시 두값중 하나는 소숫점을 가지고 있어야함
		System.out.println(sum);
		System.out.println(avg); 
		
		
		//반올림
		avg = Math.round(avg); //소수점 첫째 자리에서 반올림해준다.
		System.out.println(avg);
		
//		avg = Math.round(avg*10)/10.0; // 소수점 첫째자리에서 반올림하는 법
//		System.out.println(avg);
		
		//랜덤 : Math.random() - 0.0 ~ 1.0미만
		int random =(int)(Math.random()*100)+1; //1~100까지의 난수
		System.out.println(random);
		
		
		
		
		
		
		
	}

}
