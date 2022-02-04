package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LSG9";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection(url, user, password);
		
			String sql =" INSERT INTO GOODS VALUES('P101000001','우동','P101','1200')";
			//String sql2=" SELECT * FROM GOODS";
			ps = con.prepareStatement(sql);
			
			int result = ps.executeUpdate();
			System.out.println(result+"개의 행이 변경되었습니다.");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //닫는건 반드시 rs>ps>con순서로 닫아야함
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		
		
		
		

	}

}
