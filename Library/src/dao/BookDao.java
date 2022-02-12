package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BookDao {
	//싱글톤 패턴
	private BookDao() {}
	private static BookDao instance;
	public static BookDao getInstnace() {
		if(instance == null) {
			instance= new BookDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	//게시물 번호 조회
	public Map<String, Object> bookView(String bookNo) {
		String sql = "SELECT A.BOOK_ID"
				   + "	   , A.BOOK_NAME"
				   + "     , A.BOOK_WRITER"
				   + "     , A.BOOK_PUB"
				   + "     , B.BPROD_LOC"
				   + "     , DECODE(A.BOOK_QTY,0,'예약불가','예약가능') AS RESERVE"
				   + "  FROM BOOK A,BPROD B"
				   + " WHERE A.BPROD_ID = B.BPROD_ID"
				   + "   AND A.BOOK_ID = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(bookNo);
		
		
		return jdbc.selectOne(sql,param);
		
	}

	//제목으로 검색
	public List<Map<String, Object>> searchBookName(String BNAME) {
		String sql = "SELECT A.BOOK_NAME"
				+ "        , A.BOOK_WRITER"
				+ "        , A.BOOK_PUB"
				+ "		   , A.BOOk_ID"
				+ "     FROM BOOK A, BPROD B"
				+ "    WHERE BOOK_NAME LIKE ?"
				+ "      AND A.BPROD_ID = B.BPROD_ID";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+BNAME+"%");
		return jdbc.selectList(sql, param);
	}
	
	//저자 검색
	public List<Map<String, Object>> searchBookWriter(String BWRITER){
		String sql = "SELECT A.BOOK_NAME"
				+ "        , A.BOOK_WRITER"
				+ "        , A.BOOK_PUB"
				+ "		   , A.BOOk_ID"
				+ "     FROM BOOK A, BPROD B"
				+ "    WHERE A.BOOK_WRITER LIKE ?"
				+ "      AND A.BPROD_ID = B.BPROD_ID";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+BWRITER+"%");
		return jdbc.selectList(sql, param);
		
	}
	//출판사 검색
	public List<Map<String, Object>> searchBookPub(String BPUB){
		String sql = "SELECT A.BOOK_NAME"
				+ "        , A.BOOK_WRITER"
				+ "        , A.BOOK_PUB"
				+ "		   , A.BOOk_ID"
				+ "     FROM BOOK A, BPROD B"
				+ "    WHERE A.BOOK_PUB LIKE ?"
				+ "      AND A.BPROD_ID = B.BPROD_ID";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+BPUB+"%");
		return jdbc.selectList(sql, param);
	
	}
	//분류로 검색
	public List<Map<String, Object>> searchBookProd(String BPRODID){
		String sql = "SELECT A.BOOK_NAME"
				+ "        , A.BOOK_WRITER"
				+ "        , A.BOOK_PUB"
				+ "		   , A.BOOk_ID"
				+ "     FROM BOOK A, BPROD B"
				+ "    WHERE B.BPROD_ID LIKE ?"
				+ "      AND A.BPROD_ID = B.BPROD_ID";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+BPRODID+"%");
		return jdbc.selectList(sql, param);
	
	}
	
	public List<Map<String, Object>> bookReview(String bookno){
		String sql = "SELECT A.REVIEW_STAR," + 
				"      		 A.MEM_ID," + 
				"      		 A.REVIEW_CONTENT" + 
				" 	    FROM REVIEW A , BOOK B" + 
				" 	   WHERE A.BOOK_ID=B.BOOK_ID" + 
				"        AND A.BOOK_ID = ?"
				+ "	   ORDER BY 1";
		List<Object> param = new ArrayList<Object>();
		param.add(bookno);
		
		
		return jdbc.selectList(sql, param);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
