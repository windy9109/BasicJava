package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		
		/*
		 * Collection Framwork (배열의 발전된 형태)
		 * - List => 인덱스 순서대로 데이터저장(발전된 형태의 배열과 비슷함)
		 * - Map => 키에 값을 저장하는 형태
		 * - Set => 중복된 값을 저장 하지 않음
		 * 
		 * 
		 * ArrayList를 사용하는 이유
		 * -저장된 데이터를 읽는 속도가 빠르기때문. 대신 값을 수정,삭제등의 일은 느림
		 * 
		 * 
		 * ArrayList의 주요메서드 
		 * boolean add(Object obj): 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void add(int index, object obj): 지정된 위치에 객체를 추가한다. (ex.중간에 저장가능)
		 * 									-중간에 저장하게 되면 저장뒤의 요소들이 한칸씩 뒤로밀림
		 * Object set(int index, object obj): 지정된위치에 객체 저장후 기존객체를 반환한다.
		 * object get(int index): 지정된 위치에 객체 반환한다.(값을 얻는 메서드, 리턴받음)
		 * int size: 저장된 객체수 반환한다.(길이(수)를 반환함 => length와 같음)
		 * obfect remove(int index): 지정된 위치의 객체 제거한다. (삭제된 값 리턴됨. 값이 중간이 삭제되면 뒤에 있던 값들이 한칸씩 앞으로 당겨짐)
		 * 
		 * 
		*/
		
		
		
		ArrayList sample = new ArrayList();
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		
		//ArrayList에는 타입상관없이 아무거나 저장 가능
		//대신 값을 꺼낼때 알기가 힘듦
		
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//<Integer>는 제네릭이라고 함. 이안에 와야할 타입을 지정해줌
		//이렇게 되면 Integer만 저장할 수 있게됨.
		
		list.add(10); //저장
//		list.add("abc"); //다른타입에러
		list.add(new Integer(20)); //Integer중간의 줄은 더이상 사용하지않는 것이므로 왠만하면 쓰지말라는 표시(사장)
		
		/*
		 * Wrapper 클래스 (기본형타입을 저장하기위한 클래스)
		 * - byte	: Byte
		 * - short 	:Short 
		 * - int	: Integer
		 * - long	: Long
		 * - float	: Float
		 * - double	: Double
		 * - char	: Character
		 * - boolean: Boolean
		 * (자동으로 형변환됨)
		 * 
		*/
		
		
		System.out.println(list.add(30)); //저장의 성공여부 반환
		System.out.println(list); //안의 내용 반환
		
		list.add(1,40); 
		//1번인덱스의 자식을 저장하겠다는 뜻. 따라서 기존의 1,2번은 한칸씩밀려서 2,3번이 됨 
		System.out.println(list); 
		//현재저장된 인덱스까지만 저장가능. 새로운 인덱스 추가불가
		
		//set
		int before = list.set(2,50); 
		//기존의 저장된 값을 리턴함. 기존값에 50이 덮어씌워지고 기존값을 리턴함
		System.out.println("befor: "+before);
		System.out.println(list);
		
		
		//get
		int get = list.get(2); //2번 인덱스의 값을 읽어온다 => 50
		System.out.println(get);
		
		
		//size(for문돌릴때 많이 사용함)
		
		/*
		 * 오답
		 */
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+" : "+list.remove(0)); //리무브가 돌면서 하나씩 삭제하고
		}
		System.out.println(list); //아무것도 남지않아야함
		//결과적으로 두번만 돌게되는데 이유는 삭제되면서 앞으로 당겨지면서 2번만 돌게되는것
		//감소하는 방향으로써야함
		
		/*
		 * 정답
		 */
		for(int i=list.size()-1; i>=0; i--) {
			System.out.println(i+" : "+list.remove(i)); //리무브가 돌면서 하나씩 삭제하고
		}
		System.out.println(list); //아무것도 남지않아야함
		//정상출력
		
		
		
		
		
		//list에 1~100사이의 랜덤값을 10개 저장해주세요.
		
		//ArrayList num = new ArrayList();  
		//-> 오브젝트 상태임 이때에는 사용못하므로 아래처럼 제네릭을 지정해줘야함
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			num.add((int)(Math.random()*100)+1);	
		}
		System.out.println(num);
		//(int)(Math.random()*100)+1;
		
		
		//list에 저장된 값의 합계와 평균을 구해주세요.
		
		int sum =0;
		double avg =0;
	for(int i=0; i<num.size(); i++) {
		sum += num.get(i);
		avg = (double)sum / num.size();
	}
		System.out.println("합계: "+sum+"평균: "+avg);
		
		
		//list에서 최소값과 최대값을 구해주세요.
		
		int min=100;
		int max=0;
		for(int i=0; i<num.size(); i++) {
			if(max < num.get(i)) {
				max = num.get(i);
			}
			if(min > num.get(i)) {
				min = num.get(i);
			}
			
		}
		
		System.out.println("최대값: "+max+", 최소값:"+min);
		

		min =0;
		
		
		

		
		
		
		//list를 오름차순으로 정렬해주세요
		for(int i=0; i<num.size()-1; i++) {
			int min2 = i;
			for(int j=i+1; j<num.size(); j++) {
				if(num.get(min2) > num.get(j)) {
					min2 = j;
				}
			}
			int temp = num.get(i);
			num.set(i, num.get(min2));
			num.set(min2, temp);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			
		}
		System.out.println(num);
		
		
		
		//방법2
		for(int i=0; i<num.size(); i++) {
			int min2 = i;
			for(int j=i; j<num.size(); j++) {
				if(num.get(min2) > num.get(j)) {
					min2 = j;
				}
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
			
			num.set(i, num.set(min,num.get(i)));
		}
		System.out.println(num);
		
		
		//2차원 
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		
		list = new ArrayList<Integer>();
		list.add (10);
		list.add (20);
		list.add (30);
		list2.add (list);
		
		
		list = new ArrayList<Integer>();
		list.add(40);
		list.add(50);
		list2.add(list);

		
		System.out.println(list2);
		
		
		for(int i=0; i< list2.size(); i++) {
			ArrayList<Integer> list3 = list2.get(i);
			for(int j=0; j< list3.size(); j++) {
				System.out.print(list3.get(j)+" ");
			}
		}
		
		
		Integer integer = list2.get(0).get(1);
		System.out.println("\n"+integer);
		
		
		
		
		//학생3명의 5과목에 0~100점의 랜덤한 점수를 2차원 ArrayList에 저장해주세요.
		list2 = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<3; i++) {
			list2.add(new ArrayList<Integer>()); //3명만큼 만들고
			for(int j=0; j<5; j++) {
				list2.get(i).add((int)(Math.random()*101));
				//3명의 자리에 랜덤한값을 5개씩 넣는다.
			}
		}
		System.out.println(list2);
		
		
		//각 학생별 합계와 평균을 구해주세요.
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Double> avgs = new ArrayList<Double>();
		
		for(int i=0; i<list2.size(); i++) {
			sum = 0; //한명의 학생의 점수
			for(int j=0; j<list2.get(i).size(); j++) {
				sum += list2.get(i).get(j);
			}
			sums.add(sum);
			avgs.add((double)sum/list2.get(i).size());
		}
		
		System.out.println(sums);
		System.out.println(avgs);
		
		
	}

}
































