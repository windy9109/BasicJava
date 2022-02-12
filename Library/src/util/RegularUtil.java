package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtil {
	public static boolean idRegular(String param) {
		String str = param;
		String e = "[a-z0-9_-]{4,10}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	
	public static boolean passRegular(String param) {
		String str = param;
		String e = "[a-z0-9!@~]{4,20}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	
	public static boolean nameRegular(String param) {
		String str = param;
		String e = "[가-힣]{2,5}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	
	public static boolean birRegular(String param) {
		String str = param;
		String e = "\\d{4}/\\d{2}/\\d{2}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	public static boolean phoneRegular(String param) {
		String str = param;
		String e = "\\d{2,3}\\d{3,4}\\d{3,4}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	
	public static boolean addRegular(String param) {
		String str = param;
		String e = "[a-zA-z0-9가-힣\\s]{5,40}";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	public static boolean emailRegular(String param) {
		String str = param;
		String e = "(?i)[a-z0-9\\%?\\^%?\\&?]{5,14}@[a-z]{4,10}\\.(com|net|org|([a-z]{2}.kr))";
		Pattern p = Pattern.compile(e);
		Matcher m = p.matcher(str);
	
		
		return m.matches();
	}
	
	
	
	
	
	
}
