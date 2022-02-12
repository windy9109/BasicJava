package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ReserveDao {
	//싱글톤 패턴
		private ReserveDao() {}
		private static ReserveDao instance;
		public static ReserveDao getInstnace() {
			if(instance == null) {
				instance= new ReserveDao();
			}
			return instance;
		}
		
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public Map<String, Object> selectQty(List<Object> param){
			String sql = "SELECT BOOK_QTY"
					+ "	    FROM BOOK"
					+ "	   WHERE BOOK_ID = ?";
			
			
			
			return jdbc.selectOne(sql,param);
		}
		
		public int reservation(Map<String, Object> param) {
			String sql = "INSERT INTO RESERVATION VALUES ((SELECT NVL(MAX(RES_ID), 0)+1 FROM RESERVATION),"
					+ "                                   SYSDATE,"
					+ "                                   ?)";
			
			List<Object> p = new ArrayList<>();
			p.add(param.get("MEM_ID"));
			
			
			return jdbc.update(sql,p);
			
		}
		
		public int Dreservation(Map<String, Object> param) {
			String sql = "INSERT INTO DRESERVATION (BOOK_ID,RES_ID)"
					+ "	  VALUES(?,"
					+"         (SELECT RES_ID FROM (SELECT RES_ID"
		     	    +"		      FROM RESERVATION "
			        + " 	     WHERE ROWNUM = 1 "
	                + "		     ORDER BY RES_ID DESC)))";
			List<Object> p = new ArrayList<>();
			p.add(param.get("BOOK_ID"));
			
			
			
			return jdbc.update(sql,p);
		}
		
		public int qtyUpdate(Map<String, Object> param) {
			String sql = "UPDATE BOOK" + 
					"   SET BOOK_QTY = DECODE(BOOK_QTY,0,0,BOOK_QTY-1)" + 
					" WHERE BOOK_ID = ?";
			List<Object> p = new ArrayList<>();
			p.add(param.get("BOOK_ID"));
			
			
			
			
			return jdbc.update(sql,p);
		}
		
		
		
		
		
		
}
