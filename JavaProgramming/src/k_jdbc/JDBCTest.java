package k_jdbc;

import java.util.ArrayList;
import java.util.List; 
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		
		

		
		
		//사용	
		//[1] Map<String, Object> selectOne(String sql)	
		String sql = "select *" 
					+ " from GOODS" 
					+ " where PROD_LGU = 'P101'"
					+ " and PROD_PRICE < 22000";
	
		
		Map<String, Object> map = JDBCUtil.selectOne1(sql);
	
		System.out.println(
				"[1번] List<Map<String, Object>> - 1줄/param받지 않음" + "\n-----------------------------------------------------");
		//컬럼명
		for (String key : map.keySet()) {
			System.out.print(key + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
		for (String key : map.keySet()) {
			System.out.print(map.get(key) + "\t");
		}
	
		System.out.println("\n\n\n");
			
			
		
		
			
			
		//[2] Map<String, Object> selectOne(String sql, List<Object> param)	
		sql = "select *" 
					+ " from GOODS" 
					+ " where PROD_LGU = ?"
					+ " and PROD_PRICE < ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add("P201");
		param.add(23000);
		
		map = JDBCUtil.selectOne2(sql, param);
	
		System.out.println(
				"[2번] List<Map<String, Object>> - 1줄/param받음" + "\n-----------------------------------------------------");
		//컬럼명
		for (String key : map.keySet()) {
			System.out.print(key + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
		for (String key : map.keySet()) {
			System.out.print(map.get(key) + "\t");
		}
		System.out.println("\n\n\n");
		
		
		
		
		
			
		//[3] List<Map<String, Object>> selectList(String sql)	
		sql = "select *" 
				+ " from GOODS" 
				+ " where PROD_LGU = 'P101'"
				+"and PROD_PRICE < 22000";
		List<Map<String, Object>> list = JDBCUtil.selectList3(sql);
	
	
	
		System.out.println(
				"[3번] List<Map<String, Object>> - 여러줄/param받지 않음" + "\n-----------------------------------------------------");
		
		map = list.get(0);
		for (String key : map.keySet()) {
			System.out.print(key + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
	
		for (int i = 0; i < list.size(); i++) {
			map = list.get(i);
			for (String key : map.keySet()) {
				System.out.print(map.get(key) + "\t");
			}
			System.out.println();
		}
		
		
		System.out.println("\n\n");
	
				
				
				
				
				
		
		//[4] List<Map<String, Object>> selectList(String sql, List<Object> param)
		sql = "select *"
				+ " from GOODS"
				+ " where PROD_LGU = ?"
				+ " and PROD_PRICE < ?";
		
		param =new ArrayList<Object>();
		param.add("P201");
		param.add(23000);
		
		list = JDBCUtil.selectList4(sql, param);
		

			System.out.println("[4번] List<Map<String, Object>> - 여러줄/param받음"
					+ "\n-----------------------------------------------------");
			map = list.get(0);
			for( String key : map.keySet() ) {
				System.out.print(key+"\t");
			}
			System.out.println("\n-----------------------------------------------------");
			
		for(int i=0; i<list.size(); i++) {
			map = list.get(i);
			for( String key : map.keySet() ) {
				System.out.print(map.get(key)+"\t");
			}
			System.out.println();
		}
		System.out.println("\n\n");
		
			
		
		
		
		//[5] int update(String sql)
		sql = " INSERT INTO GOODS VALUES('P101000006','불닭볶음면','P104','2200')";
		JDBCUtil.update5(sql);
		System.out.println("\n");
		
		

		
		//[6] int update(String sql, List<Object> param)
		sql = "UPDATE GOODS"
						+ " SET PROD_NAME = ? , PROD_PRICE = ?"
						+ " WHERE PROD_NAME = ? and PROD_PRICE = ?";
		

		param = new ArrayList<Object>();
		param.add("초콜릿");
		param.add(10000);
		param.add("우동");
		param.add(1200);
		
		
		JDBCUtil.update6(sql, param);
		
		
		
		
		
		
		
	
		
		
		
		//Professor [2]
		sql = "select *"
				+ " from member"
				+ " where mem_id = ?";
		param = new ArrayList<Object>();
		param.add("a001");
		
		map = JDBCUtil.selectOne2_1(sql, param);
		System.out.println(map);
		
		
		
		//professor [6]
		sql = "INSERT INTO CART VALUES (?,?,?,?)";
		param = new ArrayList<Object>();
		param.add("a001");
		param.add("2005040100001");
		param.add("P201000019");
		param.add(3);
		
		int result = JDBCUtil.update6_1(sql, param);
		System.out.println("영향받은 행: "+result);
		
		
		
		
		
		

	}

}
