package util;

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
	
	//싱글톤 패턴: 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	private JDBCUtil(){
		
	}
	
	private static JDBCUtil instnace;
	
	public static JDBCUtil getInstance() {
		if(instnace == null) {
			instnace = new JDBCUtil();
		}
		return instnace; //첫번째 이후에는 리턴값만 반환
	}
	
	String url = "jdbc:oracle:thin:@192.168.32.51:1521:xe";
	String user = "JSC01";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql) //select의 결과가 무조건 1줄일때 사용
	 * Map<String, Object> selectOne(String sql, List<Object> param)  //List<Object> param : 쿼리에 ?가 있으면 ?에 저장되는 값
	 * 
	 * List<Map<String, Object>> selectList(String sql) //select의 결과가 여러줄일때 사용
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * 
	 * int update(String sql) //select를 제외한 나머지
	 * int update(String sql, List<Object> param)
	 */
	
	public Map<String, Object> selectOne(String sql){
		HashMap<String, Object> map = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			if(rs.next()) {
				map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
			
		}	
		return map;
	}
	
	public Map<String, Object> selectOne(String sql, List<Object> param){
		HashMap<String, Object> map = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++ ) {
			ps.setObject ( i + 1, param.get(i));
				}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			if(rs.next()) {
				map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
			
		}	
		return map;
	}
	
	public List<Map<String, Object>> selectList(String sql){
		ArrayList<Map<String,Object>> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
				
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
			
		}	
		return list;
	}
	
	
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		
		ArrayList<Map<String,Object>> list = new ArrayList<>();
			
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++ ) {
				ps.setObject(i + 1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
			
		}	
		
		return list;
		
	}
	
	public int update(String sql) {
			int result = 0;
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			
			
			result = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
			
		}	
		return result;
	}
	
	public int update(String sql, List<Object> param) {
		int result = 0;
	try {
		con = DriverManager.getConnection(url,user,password);
		
		ps = con.prepareStatement(sql);
		for(int i = 0; i < param.size(); i++ ) {
			ps.setObject(i + 1, param.get(i));
		}
		
		result = ps.executeUpdate();

		
	} catch (SQLException e) {
		e.printStackTrace();
		
	}finally {
		if(rs != null) try { rs.close(); } catch(Exception e) {}
		if(ps != null) try { ps.close(); } catch(Exception e) {}
		if(con != null) try { con.close(); } catch(Exception e) {}
		
	}	
	return result;
}
	
	
}
