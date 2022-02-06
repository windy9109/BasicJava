package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	
	private static String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "sys as sysdba";
	private static String password = "java";
	//한번에 작성하기 alt+shift+a
	
	private static Connection con1 = null;
	private static PreparedStatement ps1 = null;
	private static ResultSet rs1 = null;
	
	
	private static Connection con2 = null;
	private static PreparedStatement ps2 = null;
	private static ResultSet rs2 = null;
	
	
	private static Connection con3 = null;
	private static PreparedStatement ps3 = null;
	private static ResultSet rs3 = null;
	
	
	
	private static Connection con4 = null;
	private static PreparedStatement ps4 = null;
	private static ResultSet rs4 = null;
	
	
	
	private static Connection con5 = null;
	private static PreparedStatement ps5 = null;
	private static ResultSet rs5 = null;
	
	
	
	private static Connection con6 = null;
	private static PreparedStatement ps6 = null;
	private static ResultSet rs6 = null;
	
	
	
	/*
	 *Map<String, Object> selectOne(String sql) --물음표가 없을때사용
	 *Map<String, Object> selectOne(String sql, List<Object> param) -- 물음표가 있을때사용 / param -> 물음표에 들어갈값
	 *List<Map<String, Object>> selectList(String sql) --물음표가 없을때사용
	 *List<Map<String, Object>> selectList(String sql, List<Object> param) --물음표가 있을때사용
	 *int update(String sql) --select절을 제외한 나머지 절을 리턴함
	 *int update(String sql, List<Object> param)
	 * 
	*/
	
	
	//[1] Map<String, Object> selectOne(String sql)
	public static Map<String, Object> selectOne1 (String sql1){
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		try {
			con1 = DriverManager.getConnection(url, user, password);
			ps1 = con1.prepareStatement(sql1);
			rs1 = ps1.executeQuery(); 
		
			ResultSetMetaData metaData1 = rs1.getMetaData();
			int columnCount1 = metaData1.getColumnCount();
			
			while(rs1.next()) {
				for(int i=1; i<=columnCount1; i++) {
					map1.put(metaData1.getColumnName(i), rs1.getObject(i) );
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(rs1 != null) try {rs1.close();} catch(Exception e) {}
			if(ps1 != null) try {ps1.close();} catch(Exception e) {}
			if(con1 != null) try {con1.close();} catch(Exception e) {}
		}
		
		return map1;
		
	}
	
	
	
	
	//[2] Map<String, Object> selectOne(String sql, List<Object> param)
	public static Map<String, Object> selectOne2 (String sql2, List<Object> param2){
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		try {
			con2 = DriverManager.getConnection(url, user, password);
			ps2 = con2.prepareStatement(sql2);
			
			for(int i=0; i<param2.size(); i++) {
				ps2.setObject(i+1, param2.get(i));
			}
			
			
			rs2 = ps2.executeQuery(); 
		
			ResultSetMetaData metaData2 = rs2.getMetaData();
			int columnCount2 = metaData2.getColumnCount();
			
			while(rs2.next()) {
				for(int i=1; i<=columnCount2; i++) {
					map2.put(metaData2.getColumnName(i), rs2.getObject(i) );
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(rs2 != null) try {rs2.close();} catch(Exception e) {}
			if(ps2 != null) try {ps2.close();} catch(Exception e) {}
			if(con2 != null) try {con2.close();} catch(Exception e) {}
		}
		
		return map2;
		
	}
	
	
	
	
	
	
	
	
	//[3] List<Map<String, Object>> selectList(String sql)
	public static List<Map<String, Object>> selectList3(String sql3){
		List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>(); 
		try {
			con3 = DriverManager.getConnection(url, user, password);
			
			ps3= con3.prepareStatement(sql3); //sql문구를 ps에 넣는다.
			
			
			rs3 = ps3.executeQuery(); //쿼리실행
			//하나씩 추출해서 담는다
			ResultSetMetaData metaData3 = rs3.getMetaData();
			int columnCount3 = metaData3.getColumnCount();
			
			while(rs3.next()) {
				Map<String, Object> map3 = new HashMap<String, Object>();
				for(int i=1; i<=columnCount3; i++) {
					map3.put(metaData3.getColumnName(i), rs3.getObject(i) );
					
				//테이블의 i번째 컬럼이름들을 키로 받고 i번째 결과들을 반환한다.	
				}
				list3.add(map3);
				//이것을 list 테이블에 저장한다.
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs3 != null) try {rs3.close();} catch(Exception e) {}
			if(ps3 != null) try {ps3.close();} catch(Exception e) {}
			if(con3 != null) try {con3.close();} catch(Exception e) {}
		}
		
		return list3;
	}
	
	
	

	
	
	
	
	
	//[4] List<Map<String, Object>> selectList(String sql, List<Object> param)
	
	public static List<Map<String, Object>> selectList4(String sql4, List<Object> param4){
		List<Map<String, Object>> list4 = new ArrayList<Map<String, Object>>(); 
		try {
			con4 = DriverManager.getConnection(url, user, password);
			
			ps4= con4.prepareStatement(sql4); //sql문구를 ps에 넣는다.
			
			for(int i=0; i<param4.size(); i++) {
				ps4.setObject(i+1, param4.get(i)); //sql의 ?(물음표) 안의 
			}
			
			rs4 = ps4.executeQuery(); //쿼리실행
			//하나씩 추출해서 담는다
			ResultSetMetaData metaData4 = rs4.getMetaData();
			int columnCount4 = metaData4.getColumnCount();
			
			while(rs4.next()) {
				Map<String, Object> map4 = new HashMap<String, Object>();
				for(int i=1; i<=columnCount4; i++) {
					map4.put(metaData4.getColumnName(i), rs4.getObject(i) );
					
				//테이블의 i번째 컬럼이름들을 키로 받고 i번째 결과들을 반환한다.	
				}
				list4.add(map4);
				//이것을 list 테이블에 저장한다.
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs4 != null) try {rs4.close();} catch(Exception e) {}
			if(ps4 != null) try {ps4.close();} catch(Exception e) {}
			if(con4 != null) try {con4.close();} catch(Exception e) {}
		}
		
		return list4;
	}
	
	
	
	
	//[5] int update(String sql)
	public static void update5(String sql5) {
		try {
			con5 = DriverManager.getConnection(url, user, password);
			ps5 = con5.prepareStatement(sql5);
			int result = ps5.executeUpdate();

			System.out.println(result+"개의 행이 INSERT 되었습니다.");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(ps5 != null) try {ps5.close();} catch(Exception e) {}
			if(con5 != null) try {con5.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	//[6] int update(String sql, List<Object> param)
	public static void update6(String sql6, List<Object> param6) {
		try {
			con6 = DriverManager.getConnection(url, user, password);
			ps6 = con6.prepareStatement(sql6);
			for(int i=0; i<param6.size(); i++) {
				ps6.setObject(i+1, param6.get(i));
			}
			
			
			int result2 = ps6.executeUpdate();

			System.out.println(result2+"개의 행이 UPDATE 되었습니다.");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(ps6 != null) try {ps6.close();} catch(Exception e) {}
			if(con6 != null) try {con6.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	
	
	
	
	
	
}





