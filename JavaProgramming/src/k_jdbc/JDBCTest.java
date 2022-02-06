package k_jdbc;

import java.util.ArrayList;
import java.util.List; 
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		
		
		//사용
		//사용
//		String sql3 = "select *"
//				+ " from ALL_UNIFIED_AUDIT_ACTIONS"
//				+ " where ACTION >= ?"
//				+ " and COMPONENT = ?";
//		ArrayList<Object> param3 =new ArrayList<Object>();
//		param3.add(42);
//		param3.add("XS");
//		
//		List<Map<String, Object>> list3 = JDBCUtil.selectList3(sql3, param3);
//		
//		System.out.println(list3);
		
		
		
		//[1] Map<String, Object> selectOne(String sql)	
		String sql1 = "select *" 
					+ " from ALL_UNIFIED_AUDIT_ACTIONS" 
					+ " where ACTION = 1";
	
		
		Map<String, Object> map1 = JDBCUtil.selectOne1(sql1);
	
		System.out.println(
				"[1번] List<Map<String, Object>> - 1줄/param받지 않음" + "\n-----------------------------------------------------");
		//컬럼명
		for (String key1 : map1.keySet()) {
			System.out.print(key1 + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
		for (String key1 : map1.keySet()) {
			System.out.print(map1.get(key1) + "\t");
		}
	
		System.out.println("\n\n\n");
			
			
		
			
			
		//[2] Map<String, Object> selectOne(String sql, List<Object> param)	
		String sql2 = "select *" 
					+ " from ALL_UNIFIED_AUDIT_ACTIONS" 
					+ " where ACTION = ?";
		ArrayList<Object> param2 = new ArrayList<Object>();
		param2.add(2);
		
		
		Map<String, Object> map2 = JDBCUtil.selectOne2(sql2, param2);
	
		System.out.println(
				"[1번] List<Map<String, Object>> - 1줄/param받음" + "\n-----------------------------------------------------");
		//컬럼명
		for (String key2 : map2.keySet()) {
			System.out.print(key2 + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
		for (String key2 : map2.keySet()) {
			System.out.print(map2.get(key2) + "\t");
		}
		System.out.println("\n\n\n");
		
		
		
		
		
			
		//[3] List<Map<String, Object>> selectList(String sql)	
		String sql3 = "select *" + " from ALL_UNIFIED_AUDIT_ACTIONS" + " where ACTION = 1"+"and TYPE < 10";
		List<Map<String, Object>> list3 = JDBCUtil.selectList3(sql3);
	
	
	
		System.out.println(
				"[3번] List<Map<String, Object>> - 여러줄/param받지 않음" + "\n-----------------------------------------------------");
		Map<String, Object> map3 = list3.get(0);
		for (String key3 : map3.keySet()) {
			System.out.print(key3 + "\t");
		}
		System.out.println("\n-----------------------------------------------------");
	
		for (int i = 0; i < list3.size(); i++) {
			map3 = list3.get(i);
			for (String key3 : map3.keySet()) {
				System.out.print(map3.get(key3) + "\t");
			}
			System.out.println();
		}
		
		
		System.out.println("\n\n");
	
				
				
				
				
				
		
		//[4] List<Map<String, Object>> selectList(String sql, List<Object> param)
		String sql4 = "select *"
				+ " from ALL_UNIFIED_AUDIT_ACTIONS"
				+ " where ACTION >= ?"
				+ " and COMPONENT = ?";
		ArrayList<Object> param4 =new ArrayList<Object>();
		param4.add(47);
		param4.add("XS");
		
		List<Map<String, Object>> list4 = JDBCUtil.selectList4(sql4, param4);
		

			System.out.println("[4번] List<Map<String, Object>> - 여러줄/param받음"
					+ "\n-----------------------------------------------------");
			Map<String, Object> map4 = list4.get(0);
			for( String key4 : map4.keySet() ) {
				System.out.print(key4+"\t");
			}
			System.out.println("\n-----------------------------------------------------");
			
		for(int i=0; i<list4.size(); i++) {
			map4 = list4.get(i);
			for( String key4 : map4.keySet() ) {
				System.out.print(map4.get(key4)+"\t");
			}
			System.out.println();
		}
		System.out.println("\n\n");
		
		
		
		
		
		
		//[5] int update(String sql)
		String sql5 = " INSERT INTO ALL_UNIFIED_AUDIT_ACTIONS VALUES(920,'Commit',910,'Commit Success')";
		JDBCUtil.update5(sql5);
		System.out.println("\n");
		
		
		
		
		
		//[6] int update(String sql, List<Object> param)
		String sql6 = "UPDATE ALL_UNIFIED_AUDIT_ACTIONS"
						+ " SET TYPE = ? , ACTION = ?"
						+ " WHERE TYPE = ? and ACTION = ?";
		

		ArrayList<Object> param6 = new ArrayList<Object>();
		param6.add(43);
		param6.add(450);
		param6.add(2);
		param6.add(1);
		
		
		JDBCUtil.update6(sql6, param6);
		
		
		
		
		

	}

}
