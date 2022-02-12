package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import util.JDBCUtil;
import util.ScanUtil;

public class ManagerDao {
	private ManagerDao() {}
	private static ManagerDao instance;
	public static ManagerDao getInstnace() {
		if(instance == null) {
			instance= new ManagerDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public int insertBook(List<Object> param) {
		String sql = " INSERT INTO BOOK "
				   + " VALUES ((SELECT NVL(MAX(BOOK_ID),0)+1 FROM BOOK)"
				   + "      , ?,?,?,?,SYSDATE"
				   + "      , ?)";
		return jdbc.update(sql, param);
		
	}
	
	public int modifyBook(List<Object> param) {
		String sqlTitle = "UPDATE BOOK SET ";
		String sql = sqlMake(sqlTitle);
		return jdbc.update(sql, param);
	}
	
	
	public int deleteBook(List<Object> param) {
		String sql = " DELETE FROM BOOK "
				   + "  WHERE BOOK_ID = ?";
		return jdbc.update(sql, param);
	}
	
	
	private String sqlMake(String sqlTitle) {
		StringBuffer sb = new StringBuffer(sqlTitle);
		ArrayList<String> list = new ArrayList<>();
		list.add("수정할 제목을 입력하세요>");
		list.add("수정할 저자를 입력하세요>");
		list.add("수정할 출판사를 입력하세요>");
		list.add("수정할 책 수령을 입력하세요>");
		list.add("수정할 책 분류번호를 입력하세요>");
		ArrayList<Object> list2 = new ArrayList<>();
		list2.add("BOOK_NAME");
		list2.add("BOOK_WRITER");
		list2.add("BOOK_PUB");
		list2.add("BOOK_QTY");
		list2.add("BPROD_ID");
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			System.out.println(list.get(i));
			String input = ScanUtil.nextLine();
			if (input.isEmpty()) {
				continue;
			} else {
				map.put(list2.get(i).toString(), "'" + input + "'");
				sb.append(map.toString().replaceAll("\\{|\\}", "") + ",");
			}
		}
		sb.append(" WHERE BOOK_ID = ? ");
		sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(",")+1);
		return sb.toString();
	}
	
	//====================책 리스트 조회 화면 ==========================
	
	public List<Map<String, Object>> bookListView(){
		String sql = "SELECT A.BOOK_ID"
				   + "     , SUBSTR(A.BOOK_NAME,1,4)||'..' AS NAME"
				   + "     , SUBSTR(A.BOOK_WRITER,1,4)||'..' AS WRITER"
				   + "     , SUBSTR(A.BOOK_PUB,1,4)||'..' AS PUB"
				   + "     , A.BOOK_QTY"
				   + "     , A.BPROD_ID||'/'||B.BPROD_NAME AS KIND"
				   + "     , A.BOOK_DATE"
				   + "  FROM BOOK A, BPROD B"
				   + " WHERE A.BPROD_ID = B.BPROD_ID"
				   + " ORDER BY 7";
		return jdbc.selectList(sql);
	}
	/*
	 * ======================예약=========================
	 */
	//예약 조회
	public List<Map<String, Object>> reservListView() {
		String sql = "SELECT A.RES_ID"
			 	   + "     , A.RES_DATE"
				   + "     , A.MEM_ID"
				   + "     , B.BOOK_ID"
				   + "     , DECODE(C.BOOK_QTY,0,'대출불가','대출가능') AS RENT"
				   + "  FROM RESERVATION A, DRESERVATION B, BOOK C"
				   + " WHERE A.RES_ID = B.RES_ID"
				   + "   AND B.BOOK_ID = C.BOOK_ID";
		return jdbc.selectList(sql);
	}
	//예약 승인
	public int dreservAPV(List<Object> param) {
		String sql = "DELETE FROM DRESERVATION"
				   + " WHERE RES_ID = ?";
		return jdbc.update(sql, param);
	}
	public int reservAPV(List<Object> param) {
		String sql = "DELETE FROM RESERVATION"
				   + " WHERE RES_ID = ?";
		return jdbc.update(sql, param);
	}
	//대출 보류
	public int loanInsert(List<Object> param) {
	String sql ="INSERT INTO LOAN(LOAN_ID,LOAN_DATE,RETURN_DUE,BOOK_ID,MEM_ID)"
		       +"SELECT (SELECT NVL(MAX(LOAN_ID),0)+1 FROM LOAN)"
		       +"     , SYSDATE"
		       +"     , SYSDATE+30"
		       +"     , A.BOOK_ID"
		       +"     , B.MEM_ID"
		       +"  FROM DRESERVATION A, RESERVATION B"
		       +" WHERE A.RES_ID = B.RES_ID"
		       +"   AND A.RES_ID = ?";
		return jdbc.update(sql, param);
	}
	
	
	
	
	
	
//	public Map<String, Object> getBid(List<Object> param){
//		String sql = "SELECT BOOK_ID"
//				   + "  FROM DRESERVATION"
//				   + " WHERE RES_ID = ?";
//		
//		return jdbc.selectOne(sql, param);
//		
//	}
//	public Map<String, Object> getMid(List<Object> param){
//		String sql = "SELECT MEM_ID"
//				   + "  FROM RESERVATION"
//				   + " WHERE RES_ID = ?";
//		
//		return jdbc.selectOne(sql, param);
//		
//	}
	
	
	
	//==================대출 조회 ======================
	public List<Map<String, Object>> loanListViewD(){
		String sql = "SELECT A.LOAN_ID AS LOANID" 
				   + "     , A.LOAN_DATE AS LOANDATE"
				   + "     , A.RETURN_DUE AS DUE"
				   + "     , A.BOOK_ID AS BOOKID"
				   + "     , SUBSTR(B.BOOK_NAME,1,6)||'..' AS BNAME"
				   + "     , A.MEM_ID AS MEMID"
				   + "     , C.MEM_NAME AS MNAME"
				   + "     , DECODE(A.LOAN_CHK,NULL,'대출중','미납자','미납자','반납확인') AS CH"
				   + "  FROM LOAN A, BOOK B, MEMBER C"
				   + " WHERE A.MEM_ID = C.MEM_ID"
				   + "   AND A.BOOK_ID = B.BOOK_ID";
		return jdbc.selectList(sql);
	}
	
	//======================반납확인=====================
	public int bookReturnCheck(List<Object> param) {
		String sql = " UPDATE LOAN"
				    +"    SET LOAN_RETURN = SYSDATE,"
				    +"        LOAN_CHK = '반납확인'"
				    +"  WHERE LOAN_ID = ?";
		return jdbc.update(sql,param);
		
	}
	public int updateDefaulter() {
		String sql = " UPDATE LOAN"
				    +" SET LOAN_CHK = '미납자'"
				    +" WHERE LOAN_CHK NOT LIKE '미납자' AND SYSDATE-RETURN_DUE > 0";
		return jdbc.update(sql);
	}
	
	//=========================미납확인==========================
	public List<Map<String, Object>> defaulterList(){
		String sql =  "SELECT A.LOAN_ID AS LOANID" 
				   + "      , A.BOOK_ID AS BOOKID"
				   + "      , SUBSTR(B.BOOK_NAME,1,6)||'..' AS BNAME"
				   + "      , A.MEM_ID AS MEMID"
				   + "      , C.MEM_NAME AS MNAME"
				   + "      , C.MEM_PHONE AS PHONE"
				   + "  FROM LOAN A, BOOK B, MEMBER C"
				   + " WHERE A.MEM_ID = C.MEM_ID"
				   + "   AND A.BOOK_ID = B.BOOK_ID"
				   + "   AND LOAN_CHK LIKE '미납자'";
				
		return jdbc.selectList(sql);
		
	}
	

	public List<Map<String, Object>> boardListViewM(){
		String sql = "SELECT BOARD_NO"
				   + "     , BOARD_TITLE"
				   + "     , BOARD_DATE"
				   + "     , MEM_ID"
				   + "  FROM BOARD";
		return jdbc.selectList(sql);
		
	}
	
	public Map<String, Object> getBoard(List<Object> param){
		String sql = "SELECT BOARD_TITLE"
				   + "     , BOARD_CONTENT"
				   + "     , BOARD_DATE"
				   + "     , MEM_ID"
				   + "  FROM BOARD"
				   + " WHERE BOARD_NO = ?";
		return jdbc.selectOne(sql, param);
		
	}
	
	public int boardDelete(List<Object> param) {
		String sql = "DELETE FROM BOARD"
				+    " WHERE BOARD_NO = ?";
		return jdbc.update(sql, param);
	}
	
	public List<Map<String, Object>> noticeBoardDaoM() {
		String sql = "SELECT NOTICE_NO"
				   + "     , NOTICE_TITLE"
				   + "     , NOTICE_DATE"
				   + "  FROM NOTICE";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> noticeCheck(List<Object> param){
		String sql = "SELECT NOTICE_NO"
				   + "     , NOTICE_TITLE"
				   + "     , NOTICE_CONTENT"
				   + "     , NOTICE_DATE"
				   + "  FROM NOTICE"
				   + " WHERE NOTICE_NO = ? ";
		return jdbc.selectOne(sql, param);
	}
	
	public int noticeModify(List<Object> param) {
		String sqltitle = " UPDATE NOTICE SET ";
		String sql = sqlMake2(sqltitle);
		return jdbc.update(sql, param);
	}
	
	public String sqlMake2(String sqltitle) {
		StringBuffer sb = new StringBuffer(sqltitle);
		ArrayList<String> list = new ArrayList<>();
		list.add("수정할 제목을 입력하세요>");
		list.add("수정할 내용을 입력하세요>");
		ArrayList<Object> list2 = new ArrayList<>();
		list2.add(" NOTICE_TITLE ");
		list2.add(" NOTICE_CONTENT ");
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			System.out.println(list.get(i));
			String input = ScanUtil.nextLine();
			if (input.isEmpty()) {
				continue;
			} else {
				map.put(list2.get(i).toString(), "'" + input + "'");
				sb.append(map.toString().replaceAll("\\{|\\}", "") + ",");
			}
		}
		sb.append(" WHERE NOTICE_NO = ? ");
		sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(",")+1);
		return sb.toString();
	}
	
	public int noticeDelete(List<Object> param) {
		String sql = "DELETE FROM NOTICE"
				   + " WHERE NOTICE_NO = ?";
		return jdbc.update(sql, param);
	}
	
	public int noticeRegistDao(List<Object> param) {
		String sql = " INSERT INTO NOTICE" 
				    +" VALUES ((SELECT NVL(MAX(NOTICE_NO), 0)+1 FROM NOTICE)"
				    +"      , ?,?,SYSDATE)";
		return jdbc.update(sql, param);
		
	}
	
	public List<Map<String, Object>> reviewCheck(){
		String sql = "SELECT A.REVIEW_NO AS REVIEW_NO"
				   + "     , B.BOOK_ID AS BOOK_ID"
				   + "     , SUBSTR(A.REVIEW_CONTENT,1,5)||'..' AS CONTENT"
				   + "     , A.REVIEW_STAR AS REVIEW_STAR"
				   + "  FROM REVIEW A, BOOK B"
				   + " WHERE A.BOOK_ID = B.BOOK_ID";
		
		return jdbc.selectList(sql);
		
	}
	public Map<String, Object> reviewInfo(List<Object> param){
		String sql = "SELECT B.BOOK_ID AS BOOK_ID"
				   + "     , B.BOOK_NAME AS BOOK_NAME"
				   + "     , A.REVIEW_CONTENT AS REVIEW_CONTENT" 
				   + "     , A.REVIEW_STAR AS REVIEW_STAR"
				   + "  FROM REVIEW A, BOOK B"
				   + " WHERE A.BOOK_ID = B.BOOK_ID"
				   + "   AND REVIEW_NO = ?";
		return jdbc.selectOne(sql, param);
	}
	
	public int loanCountM (List<Object> param) {
		String sql = "UPDATE MEMBER" + 
				"   SET MEM_LCN = DECODE(MEM_LCN,0,0,MEM_LCN-1)" + 
				" WHERE MEM_ID = ?";
		
		return jdbc.update(sql, param);
	}
	
	public int loanCountP (List<Object> param) {
		String sql = "UPDATE MEMBER" + 
				"   SET MEM_LCN = DECODE(MEM_LCN,3,3,MEM_LCN+1)" + 
				" WHERE MEM_ID = ?";
		
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> loanCount(List<Object>param){
		String sql = "SELECT DISTINCT(B.MEM_LCN) AS MEM_LCN," +  //if문
				"       B.MEM_ID AS MEM_ID" + 
				"  FROM MEMBER B ,RESERVATION C" + 
				" WHERE C.MEM_ID=B.MEM_ID" + 
				"   AND C.RES_ID = ?";
		
		return jdbc.selectOne(sql,param);
	}
	
	

}
