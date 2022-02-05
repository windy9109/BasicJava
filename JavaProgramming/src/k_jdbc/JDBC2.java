package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 { 

	public static void main(String[] args) {
		//데이터베이스 접속 정보
		String url ="jdbc:oracle:thin:@localhost:1521:xe"; 
		// jdbc:oracle:thinL=> jdbc의 버전을 뜻함, localhost:1521:xe는 오라클 접속자정보를 뜻함(호스트이름,포트,SID)
		//호스트이름 대신 ip이름을 적으면 다른컴퓨터에 접속가능
		String user ="LSG9";
		String password ="java";
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * "
					+ " from cart " //줄바꿈시 공백이 반드시 있어야함. 공백이 없으면 붙어있는것.
					+ " where cart_member = ? "  //값을 작은따옴표로 포함시키는게 아니라 물음표로 대체하고 나중에 채워넣는것.
					//+ " where mem_add1 like '%'||?||'%'"; like검색
					+ " and cart_qty > ?";
			ps= con.prepareStatement(sql);
			ps.setString(1, "a001");  //물음표 첫번째 값에 a001을 넣겠다
			ps.setInt(2,5); //물음표 두번째 값에 5를 넣겠다.
		//	ps.setObject(0,sql); -> 타입에 상관없이 넣을수있음
		//	물음표에는 값만 들어갈수 있음(테이블명, 컬럼 x)
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//메타데이터: 데이터에 대한 데이터
			//데이터의 타입등을 알아낼수있는 데이터
			
			int columnCount = metaData.getColumnCount(); //컬럼수
			
			
			while(rs.next()) {
				for(int i=1; i<= columnCount; i++) {
					//컬럼의 인덱스가 1부터 시작하므로 i는 1부터
					//물음표의 인덱스도 1부터
					System.out.print(rs.getObject(i)+"\t");
				}
				System.out.println();
			}
			
			
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
