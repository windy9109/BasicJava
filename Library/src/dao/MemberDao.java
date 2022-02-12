package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao {
	//싱글톤 패턴
		private MemberDao() {}
		private static MemberDao instance;
		public static MemberDao getInstnace() {
			if(instance == null) {
				instance= new MemberDao();
			}
			return instance;
		}
		
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		
		public int insertMember(Map<String, Object> param) {
			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?) ";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_ID"));
			p.add(param.get("MEM_PASS"));
			p.add(param.get("MEM_NAME"));
			p.add(param.get("MEM_PHONE"));
			p.add(param.get("MEM_ADD"));
			p.add(param.get("MEM_EMAIL"));
			p.add(param.get("MEM_LCN"));
			
			return jdbc.update(sql,p);

		}
		public Map<String, Object> selectMember(String memId, String memPass) {
			String sql = "SELECT MEM_ID, MEM_PASS, MEM_NAME"
					+ "     FROM MEMBER"
					+ "    WHERE MEM_ID = ?"
					+ "      AND MEM_PASS = ?";
			List<Object> param = new ArrayList<>();
			param.add(memId);
			param.add(memPass);
			
			return jdbc.selectOne(sql,param);
		}
		
		public List<Map<String, Object>> viewReservation(Map<String , Object> param){
			String sql = "SELECT A.RES_ID," + 
					"            B.BOOK_ID," + 
					"            SUBSTR(C.BOOK_NAME,1,5)||'...' AS BOOK_NAME," + 
					"            A.RES_DATE " + 
					"       FROM RESERVATION A, DRESERVATION B, BOOK C" + 
					"      WHERE A.RES_ID=B.RES_ID" + 
					"        AND B.BOOK_ID=C.BOOK_ID" + 
					"        AND A.MEM_ID = ?" + 
					"      ORDER BY 4";
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.selectList(sql, p);
			
		}
		
		public int deleteDReservation(Map<String, Object> param) { //예약상세
			String sql = "DELETE FROM DRESERVATION" + 
					"      WHERE RES_ID = ?";
			List<Object> p = new ArrayList<>();
			p.add(param.get("RES_ID"));
			
			
			return jdbc.update(sql,p);
		}
		
		public int deleteReservation(Map<String, Object> param) { //예약
			String sql = "DELETE FROM RESERVATION" + 
					"      WHERE RES_ID = ?";
			List<Object> p = new ArrayList<>();
			p.add(param.get("RES_ID"));
			
			
			return jdbc.update(sql,p);
		}
		
		public int updateQty(Map<String, Object> param) { //예약
			String sql = "UPDATE BOOK" + 
					"        SET BOOK_QTY = BOOK_QTY + 1" + 
					"      WHERE BOOK_ID = ?";
			List<Object> p = new ArrayList<>();
			p.add(param.get("BOOK_ID"));
			
			
			return jdbc.update(sql,p);
		}
		public Map<String, Object>selectBook_Id(Map<String, Object> param){
			Map<String, Object> map = null;
			String sql = "SELECT A.BOOK_ID AS BOOK_ID" + 
					"          FROM BOOK A, DRESERVATION B" + 
					"         WHERE A.BOOK_ID=B.BOOK_ID" + 
					"           AND B.RES_ID = ?";
			List<Object>p = new ArrayList<>();
			p.add(param.get("RES_ID"));
			
			map = jdbc.selectOne(sql, p);
			
			
			return map;
					
		}
		
		
		public int rePass(Map<String, Object> param) {
			String sql = "UPDATE MEMBER" + 
					"        SET MEM_PASS = ?" + 
					"      WHERE MEM_ID = ?";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_PASS"));
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
		}
		public int reName(Map<String, Object> param) {
			String sql = "UPDATE MEMBER" + 
					"        SET MEM_NAME = ?" + 
					"      WHERE MEM_ID = ?";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_NAME"));
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
		}
		
		public int rePhone(Map<String, Object> param) {
			String sql = "UPDATE MEMBER" + 
					"        SET MEM_PHONE = ?" + 
					"      WHERE MEM_ID = ?";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_PHONE"));
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
		}
		public int reAdd(Map<String, Object> param) {
			String sql = "UPDATE MEMBER" + 
					"        SET MEM_ADD = ?" + 
					"      WHERE MEM_ID = ?";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_ADD"));
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
		}
		public int reEmail(Map<String, Object> param) {
			String sql = "UPDATE MEMBER" + 
					"        SET MEM_EMAIL = ?" + 
					"      WHERE MEM_ID = ?";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_EMAIL"));
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
		}
		public List<Map<String, Object>> boardList(List<Object> param) {
			String sql = "SELECT BOARD_NO," + 
					"            BOARD_TITLE," + 
					"            BOARD_DATE" + 
					"       FROM BOARD" + 
					"      WHERE MEM_ID = ?";
			
			return jdbc.selectList(sql, param);
		}
		
		public List<Map<String, Object>> LoanList(List<Object> param) {
			String sql = "SELECT A.LOAN_ID," + 
					"       SUBSTR(B.BOOK_NAME,1,5)||'...' AS BOOK_NAME," + 
					"       A.LOAN_DATE," + 
					"       A.RETURN_DUE,"+
				    "       DECODE(A.LOAN_RETURN,NULL,'대출중',A.LOAN_RETURN) AS LOAN_RETURN," + 
					"       DECODE(A.LOAN_CHK,NULL,'반납안됨','반납확인') AS LOAN_CHK" + 
					"  FROM LOAN A, BOOK B, MEMBER C" + 
					" WHERE A.MEM_ID = C.MEM_ID" + 
					"   AND A.BOOK_ID = B.BOOK_ID" + 
					"   AND A.MEM_ID= ?";
			
			return jdbc.selectList(sql, param);
		}
		
		public Map<String, Object> loanSearchBook(String input){
			String sql = "SELECT BOOK_ID,"
					+ "			 LOAN_CHK" + 
					"  FROM LOAN" + 
					" WHERE LOAN_ID = ?";
			List<Object> param = new  ArrayList<>();
			param.add(input); 
			return jdbc.selectOne(sql, param);
		}
		
		public int insertReview(List<Object> param) {
			String sql = " INSERT INTO REVIEW VALUES ((SELECT NVL(MAX(REVIEW_NO), 0)+1 FROM REVIEW)," + 
					"                            ?,?,?,?)";

			return jdbc.update(sql,param);
		}
		
		public List<Map<String, Object>> reviewList(List<Object> param) {
			String sql = "SELECT A.REVIEW_NO," + 
					"       A.REVIEW_STAR," + 
					"       SUBSTR(A.REVIEW_CONTENT,1,5)||'...' AS REVIEW_CONTENT," + 
					"       SUBSTR(B.BOOK_NAME,1,5)||'...' AS BOOK_NAME" + 
					"  FROM REVIEW A ,BOOK B" + 
					" WHERE MEM_ID = ?"
					+ " AND A.BOOK_ID=B.BOOK_ID";
			
			return jdbc.selectList(sql, param);
		}
		
		public Map<String, Object> Dreview(List<Object> param) {
			String sql = "SELECT A.REVIEW_NO," + 
					"       B.BOOK_NAME," + 
					"       A.REVIEW_STAR," + 
					"       A.REVIEW_CONTENT" + 
					"  FROM REVIEW A, BOOK B" + 
					" WHERE A.BOOK_ID=B.BOOK_ID" + 
					"   AND A.REVIEW_NO = ?"
					+ " AND A.MEM_ID = ?";
		
			
			return jdbc.selectOne(sql,param);
		}
		
		public Map<String, Object> my_view(List<Object> param) {
			String sql = "SELECT * " + 
					"  FROM MEMBER" + 
					" WHERE MEM_ID = ?";
		
			
			return jdbc.selectOne(sql,param);
		}
		
		public Map<String, Object> searchID(List<Object> param) {
			String sql = "SELECT MEM_ID" + 
					"  FROM MEMBER" + 
					" WHERE MEM_ID = ?";
			
			return jdbc.selectOne(sql,param);
		}
		
		
		
}
