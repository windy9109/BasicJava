package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value): 지정된 키와 값을 저장한다.
		 * Object remove(Object key): 저장된 키로 저장된 값을 제거한다.
		 * Object get(Object key): 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet(): 저장된 모든 키를 Set로 반환한다.
		 * 		
		*/
		
		//해쉬타입은 순서라는 개념이 없으므로 어떤순서로 저장될지 알수없다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		System.out.println(map);
	
		//새로운 값으로 덮어 씌움
		map.put("name","이순신");
		System.out.println(map);
		
		//삭제
		map.remove("date");
		System.out.println(map);
		
		//저장된 값을 얻을 수있음
		Object value = map.get("name");
		//리턴되는 값도 Object이다.
		System.out.println(((String)value).substring(0,2));
		System.out.println(((String)value).substring(0,1));
		//String으로 형변환하고 사용해야함
		
		
		String value2 = (String)map.get("name");
		
		
		Set<String> keys = map.keySet();
		//값을 하나씩 꺼낼수있는 메소드가 존재하지 않음
		//for문을 사용해 꺼내야함. 형태가 for문임
		
		for(String key : keys) { //key : keys -> 변수(왼쪽):여러데이터(오른쪽)
			//오른쪽데이터를 왼쪽에 저장하여 출력함.
			System.out.println(key+":"+map.get(key));
		}
		
		
		//SQL에서 테이블 구조를 표현할때 주로사용
		
		
		
		//테이블 만들어서 저장하기
		ArrayList<HashMap<String, Object>> lprodTeble = new ArrayList<HashMap<String, Object>>();
		
		
		HashMap<String, Object> lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID",1);
		lprod.put("LPROD_GU","P101");
		lprod.put("LPROD_NM","컴퓨터제품");
		lprodTeble.add(lprod);

		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID",2);
		lprod.put("LPROD_GU","P102");
		lprod.put("LPROD_NM","전자제품");
		lprodTeble.add(lprod);

		
		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID",3);
		lprod.put("LPROD_GU","P201");
		lprod.put("LPROD_NM","여성캐주얼");
		lprodTeble.add(lprod);


		
		for(int i=0; i<lprodTeble.size(); i++) {
			lprod = lprodTeble.get(i);
			for(String key: lprod.keySet()) {
				System.out.print(lprod.get(key)+"\t");
			}
			System.out.println();
		}
		
		
//		for(String key9 : keys2) {
//			System.out.println(key9+": "+lprod.get(key9));
//		}
		
//		for(String key0 : keys2) { //key : keys -> 변수(왼쪽):여러데이터(오른쪽)
//			//오른쪽데이터를 왼쪽에 저장하여 출력함.
//			System.out.println(key0+":"+map.get(key0));
//		}
		
		
		
	}

}










