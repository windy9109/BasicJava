package boardSQL;

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

import e_oop.ScanUtil;

public class BoardQuery {
	
	//데이터베이스 접속 정보
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "LSG9";
	private static String password ="java";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	

	

//	int BOARD_NO;
//	String TITLE;
//	String CONTENT;
//	String MEM_ID;
//	BoardQuery(int BOARD_NO, String TITLE, String CONTENT, String MEM_ID){
//		this.BOARD_NO = BOARD_NO;
//		this.TITLE = TITLE;
//		this.CONTENT = CONTENT;
//		this.MEM_ID = MEM_ID;
//	}
	
	
	
	
	//목록출력
	public static List<Map<String, Object>> selectList(String sql){
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps= con.prepareStatement(sql); //sql문구를 ps에 넣는다.
			
			
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
	
	
	
	//값 입력
	 static List<Object> print() {

		 	System.out.println("제목을 입력해주세요");
			//int BOARD_NO = ScanUtil.nextInt();
			String TITLE = ScanUtil.nextLine();
			System.out.println("내용을 입력해주세요");
			String CONTENT = ScanUtil.nextLine();
			System.out.println("작성자명을 입력해주세요");
			String MEM_ID = ScanUtil.nextLine();
			
			ArrayList<Object> param = new ArrayList<Object>();
			//param.add(BOARD_NO);	
			param.add(TITLE);
			param.add(CONTENT);
			param.add(MEM_ID);

			return param;
	 }
	
	//데이터 삽입
	
	public static int insert(String sql, List<Object> param) {
		int result=0;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i=0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			
			result = ps.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
		
	}
	
	
	
	
	//입력받을 값
	//System.out.println(sc);
	
	
	
	
}
