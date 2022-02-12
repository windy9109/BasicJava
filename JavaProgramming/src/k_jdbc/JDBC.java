package k_jdbc;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC { 

	public static void main(String[] args) {
		/*
		 * JDBC
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc: 오라클 JDBC
		 * 
		 * 
		 * JDBC적성단계
		 * 
		 * 1.Connection (객체)생성(DB연결)
		 * 2.Statement 생성(쿼리작성)
		 * 3.Query 실행
		 * 4.ResultSet에서 결과 추출(select인 경우)
		 * 5.ResultSet, Statement, Connection (객체)닫기
		 * 
		 * 
		*/
		
		
		//데이터베이스 접속 정보
		String url ="jdbc:oracle:thin:@192.168.134.3:1521:xe"; 
		// jdbc:oracle:thinL=> jdbc의 버전을 뜻함, localhost:1521:xe는 오라클 접속자정보를 뜻함(호스트이름,포트,SID)
		//호스트이름 대신 ip이름을 적으면 다른컴퓨터에 접속가능
		String user ="SEM";
		String password ="java";
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//DriverManager: 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
		//기본적으로 오라클과 자바는 상호작용할 수 없으나 드라이버를 통해 상호작용 할 수있다.
		//많은 종류의 드라이버를 관리하고 연결해주는게 DriverManager이다
		
		//연결완료!
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member";  //기존의 오라클작성문과 똑같이 적으면됨
			ps = con.prepareStatement(sql); //문자열로된 쿼리를 오라클에 적합한 형태로 바꿔서 리턴해주는 역할을 함
			
			//ps.executeQuery(); //쿼리출력
			//select 일때(아래)
			rs = ps.executeQuery(); //rs로 결과 받음
			//insert, update, delete 일때(아래)
			//int result =  ps.executeUpdate();
			//result: 영향을 받은 행의 수
			
			//ps.executeQuery();과 ps.executeUpdate();은 리턴타입의 차이가 있다.
			
			while(rs.next()) { //next는 다음줄에 접근하라는뜻(next를 호출하면 결과의 첫번째를 바라보게됨. 그 다음행이 없을때까지 반복함)
				String memId = rs.getString(1); //컬럼의 인덱스 넘기기
				String memPass = rs.getString("MEM_PASS"); //컬럼명 넘기기
				System.out.println("MEM_ID: "+memId+" / MEM_PASS: "+memPass); //하나씩 출력
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫는건 반드시 rs>ps>con순서로 닫아야함
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}










