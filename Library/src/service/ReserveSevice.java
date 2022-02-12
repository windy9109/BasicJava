package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ReserveDao;
import util.ScanUtil;
import util.View;

public class ReserveSevice {
	//싱글톤 패턴
	private ReserveSevice() {}
	private static ReserveSevice instance;
	public static ReserveSevice getInstnace() {
		if(instance == null) {
			instance= new ReserveSevice();
		}
		return instance;
	}
	private ReserveDao reserveDao = ReserveDao.getInstnace();

	
	public int prodReservation() {
		Map<String, Object> member = new HashMap<>();
		member = Controller.LoginMember;
		System.out.println("_________________________________________________");
		System.out.print("정말 예약 하시겠습니까? (y,n) > ");
		String input = ScanUtil.nextLine();
		List<Object> p = new ArrayList<>();
		p.add(BookService.bookno);
		
		Map<String, Object> bookQty = reserveDao.selectQty(p);
		try {
		switch(input) {
		case "y":
			if(0 <  Integer.parseInt(String.valueOf(bookQty.get("BOOK_QTY")))) {
			Map<String,Object> param = new HashMap<>();
			param.put("MEM_ID", member.get("MEM_ID"));
			param.put("BOOK_ID", BookService.bookno);
			reserveDao.reservation(param);
			reserveDao.Dreservation(param);
			reserveDao.qtyUpdate(param);
			System.out.println("예약이 완료되었습니다.");
			System.out.println("__________________________________________________");
			return View.BOOK_PRODLIST;
			}
			else {
				System.out.println("수량이 부족합니다.");
				System.out.println("__________________________________________________");
				return View.BOOK_PRODLIST;
			}
		
			
		case "n":
			return View.BOOK_PRODLIST;
		}
		
		return View.PRODRESERVATION;
		}catch (Exception e) {
			System.out.println("로그인후 이용하세요.");
			return View.BOOK_PRODLIST;
		}
		
	}
	public int writerReservation() {
		Map<String, Object> member = new HashMap<>();
		member = Controller.LoginMember;
		System.out.println("_________________________________________________");
		System.out.print("정말 예약 하시겠습니까? (y,n) > ");
		String input = ScanUtil.nextLine();
		List<Object> p = new ArrayList<>();
		p.add(BookService.bookno);
		
		Map<String, Object> bookQty = reserveDao.selectQty(p);
		
		try {
			switch(input) {
			case "y":
				if(0 <  Integer.parseInt(String.valueOf(bookQty.get("BOOK_QTY")))) {
				Map<String,Object> param = new HashMap<>();
				param.put("MEM_ID", member.get("MEM_ID"));
				param.put("BOOK_ID", BookService.bookno);
				reserveDao.reservation(param);
				reserveDao.Dreservation(param);
				reserveDao.qtyUpdate(param);
				System.out.println("예약이 완료되었습니다.");
				System.out.println("__________________________________________________");
				return View.BOOK_WRITERLIST;
				}
				else {
					System.out.println("수량이 부족합니다.");
					System.out.println("__________________________________________________");
					return View.BOOK_WRITERLIST;
				}
			
				
			case "n":
				return View.BOOK_WRITERLIST;
			}
			
			return View.WRITERRESERVATION;
			}catch (Exception e) {
				System.out.println("로그인후 이용하세요.");
				return View.BOOK_WRITERLIST;
			}
		
	}
	public int nameReservation() {
		Map<String, Object> member = new HashMap<>();
		member = Controller.LoginMember;
		System.out.println("_________________________________________________");
		System.out.print("정말 예약 하시겠습니까? (y,n) > ");
		String input = ScanUtil.nextLine();
		
		List<Object> p = new ArrayList<>();
		p.add(BookService.bookno);
		
		Map<String, Object> bookQty = reserveDao.selectQty(p);
		
		try {
			switch(input) {
			case "y":
				if(0 <  Integer.parseInt(String.valueOf(bookQty.get("BOOK_QTY")))) {
				Map<String,Object> param = new HashMap<>();
				param.put("MEM_ID", member.get("MEM_ID"));
				param.put("BOOK_ID", BookService.bookno);
				reserveDao.reservation(param);
				reserveDao.Dreservation(param);
				reserveDao.qtyUpdate(param);
				System.out.println("예약이 완료되었습니다.");
				System.out.println("__________________________________________________");
				return View.BOOK_NAMELIST;
				}
				else {
					System.out.println("수량이 부족합니다.");
					System.out.println("__________________________________________________");
					return View.BOOK_NAMELIST;
				}
			
				
			case "n":
				return View.BOOK_NAMELIST;
			}
			
			return View.NAMERESERVATION;
			}catch (Exception e) {
				System.out.println("로그인후 이용하세요.");
				return View.BOOK_NAMELIST;
			}
	}
	public int pubReservation() {
		Map<String, Object> member = new HashMap<>();
		member = Controller.LoginMember;
		System.out.println("_________________________________________________");
		System.out.print("정말 예약 하시겠습니까? (y,n) > ");
		String input = ScanUtil.nextLine();
		
		List<Object> p = new ArrayList<>();
		p.add(BookService.bookno);
		
		Map<String, Object> bookQty = reserveDao.selectQty(p);
		
		try {
			switch(input) {
			case "y":
				if(0 <  Integer.parseInt(String.valueOf(bookQty.get("BOOK_QTY")))) {
				Map<String,Object> param = new HashMap<>();
				param.put("MEM_ID", member.get("MEM_ID"));
				param.put("BOOK_ID", BookService.bookno);
				reserveDao.reservation(param);
				reserveDao.Dreservation(param);
				reserveDao.qtyUpdate(param);
				System.out.println("예약이 완료되었습니다.");
				System.out.println("__________________________________________________");
				return View.BOOK_PUBLIST;
				}
				else {
					System.out.println("수량이 부족합니다.");
					System.out.println("__________________________________________________");
					return View.BOOK_PUBLIST;
				}
			
				
			case "n":
				return View.BOOK_PUBLIST;
			}
			
			return View.PUBRESERVATION;
			}catch (Exception e) {
				System.out.println("로그인후 이용하세요.");
				return View.BOOK_PUBLIST;
			}
		
	}

	
	
	
	

}
