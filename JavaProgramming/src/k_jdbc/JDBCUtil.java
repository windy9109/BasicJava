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
	private static String user = "LSG9";
	private static String password = "java";
	//한번에 작성하기 alt+shift+a
	 
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	/*
	 *Map<String, Object> selectOne(String sql) --물음표가 없을때사용
	 *Map<String, Object> selectOne(String sql, Last<Object> param) -- 물음표가 있을때사용 / param -> 물음표에 들어갈값
	 *List<Map<String, Object>> selectList(String sql) --조회결과가 한줄일때 사용하는 메서드(물음표가 없을때사용)
	 *List<Map<String, Object>> selectList(String sql, List<Object> param) --조회결과가 여러줄이 나올수 있을때 사용하는 메서드(물음표가 있을때사용)
	 *int update(String sql) --select절을 제외한 나머지 절을 리턴함
	 *int update(String sql, List<Object> param)
	 * 
	*/
	
	 
	public static List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps= con.prepareStatement(sql);
			
			for(int i=0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			rs = ps.executeQuery(); //쿼리실행
			//하나씩 추출해서 담는다
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i=1; i<=columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i) );
					
				}
				list.add(map);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //닫는건 반드시 rs>ps>con순서로 닫아야함
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
}
