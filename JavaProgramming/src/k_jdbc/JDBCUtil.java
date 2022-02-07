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
	 *Map<String, Object> selectOne(String sql, List<Object> param) -- 물음표가 있을때사용 / param -> 물음표에 들어갈값
	 *List<Map<String, Object>> selectList(String sql) --물음표가 없을때사용
	 *List<Map<String, Object>> selectList(String sql, List<Object> param) --물음표가 있을때사용
	 *int update(String sql) --select절을 제외한 나머지 절을 리턴함
	 *int update(String sql, List<Object> param)
	 * 
	*/
	
	
	
	//[1] Map<String, Object> selectOne(String sql) -Professor
	public static Map<String, Object> selectOne1_1 (String sql, List<Object>param){
		//한줄도 없을때는 무엇을 리턴할 것인가를 생각한다. => 빈 hashMap보다는 null이 넘어오게끔한다.
		Map<String, Object> map = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			//여러번 반복될 필요가 없음
			//조회컬럼이 null인경우 실행될 필요가 없으므로 if에 넣는다.
			if(rs.next()) {
				map = new HashMap<String, Object>();
				for(int i =1; i<= columnCount; i++){
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return map;
		
	}
	
	
	
	
	
	
	
	//[1] Map<String, Object> selectOne(String sql)
	public static Map<String, Object> selectOne1 (String sql){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
		
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				for(int i=1; i<=columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i) );
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return map;
		
	}
	
	
	
	
	
	
	//[2] Map<String, Object> selectOne(String sql, List<Object> param) -Professor
	public static Map<String, Object> selectOne2_1 (String sql, List<Object>param){
		//한줄도 없을때는 무엇을 리턴할 것인가를 생각한다. => 빈 hashMap보다는 null이 넘어오게끔한다.
		Map<String, Object> map = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i=0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			//여러번 반복될 필요가 없음
			//조회컬럼이 null인경우 실행될 필요가 없으므로 if에 넣는다.
			if(rs.next()) {
				map = new HashMap<String, Object>();
				for(int i =1; i<= columnCount; i++){
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	//[2] Map<String, Object> selectOne(String sql, List<Object> param)
	public static Map<String, Object> selectOne2 (String sql2, List<Object> param2){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql2);
			
			for(int i=0; i<param2.size(); i++) {
				ps.setObject(i+1, param2.get(i));
			}
			
			
			rs = ps.executeQuery(); 
		
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				for(int i=1; i<=columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i) );
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	//[3] List<Map<String, Object>> selectList(String sql)
	public static List<Map<String, Object>> selectList3(String sql3){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps= con.prepareStatement(sql3); //sql문구를 ps에 넣는다.
			
			
			rs = ps.executeQuery(); //쿼리실행
			//하나씩 추출해서 담는다
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i=1; i<=columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i) );
					
				//테이블의 i번째 컬럼이름들을 키로 받고 i번째 결과들을 반환한다.	
				}
				list.add(map);
				//이것을 list 테이블에 저장한다.
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return list;
	}
	
	
	

	
	
	
	
	
	//[4] List<Map<String, Object>> selectList(String sql, List<Object> param)
	
	public static List<Map<String, Object>> selectList4(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps= con.prepareStatement(sql); //sql문구를 ps에 넣는다.
			
			for(int i=0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i)); //sql의 ?(물음표) 안의 
			}
			
			rs = ps.executeQuery(); //쿼리실행
			//하나씩 추출해서 담는다
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i=1; i<=columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i) );
					
				//테이블의 i번째 컬럼이름들을 키로 받고 i번째 결과들을 반환한다.	
				}
				list.add(map);
				//이것을 list 테이블에 저장한다.
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return list;
	}
	
	
	
	
	//[5] int update(String sql)
	public static void update5(String sql) {
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();

			System.out.println(result+"개의 행이 INSERT 되었습니다.");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	//[6] int update(String sql, List<Object> param)
	public static void update6(String sql, List<Object> param) {
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i=0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			
			int result = ps.executeUpdate();

			System.out.println(result+"개의 행이 UPDATE 되었습니다.");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	
	//[6] int update(String sql, List<Object> param) - Professor
		public static int update6_1(String sql, List<Object> param) {
			int result=0;
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				for(int i=0; i<param.size(); i++) {
					ps.setObject(i+1, param.get(i));
				}
				
				
				result = ps.executeUpdate();

				System.out.println(result+"개의 행이 UPDATE 되었습니다.");
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally { 
				if(ps != null) try {ps.close();} catch(Exception e) {}
				if(con != null) try {con.close();} catch(Exception e) {}
			}
			return result;
			
		}
	
	
	
	
	
	
	
}





