package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC3 {

	public static void main(String[] args) {
		
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LSG9";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		try {
			con = DriverManager.getConnection(url, user, password);
		
		//테이블 하나를 정해서 select, insert, update, delete 하시오
		String sql = " SELECT * "
				+ " FROM GOODS "
				+ " WHERE PROD_ID LIKE ?||'%'";
		ps = con.prepareStatement(sql);
		ps.setObject(1,"P101");
		
		rs = ps.executeQuery();
		
		
		System.out.println("<< SELECT >>");
		while(rs.next()) {
			String prod_id = rs.getString(1);
			String prod_name = rs.getString("PROD_NAME");
			System.out.println("PROD_ID: "+prod_id+" / PROD_NAME: "+prod_name);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //닫는건 반드시 rs>ps>con순서로 닫아야함
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
	}

}
