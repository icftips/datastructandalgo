package recurrsion;

import java.util.HashMap;

public class PhoneDialer {
	public static HashMap<String, String> map = new HashMap<>();
	
	static {
		map.put("0", "0");
		map.put("1", "1");
		map.put("2", "ABC");
		map.put("3", "DEF");
		map.put("4", "GHI");
		map.put("5", "JKL");
		map.put("6", "MNO");
		map.put("7", "PQRS");
		map.put("8", "TUV");
		map.put("9", "WXYZ");
	}
	
	public static void main(String[] args) {
		System.out.println(map.keySet().toString());
		print("");
	}
	
	public static void print(String number) {
		if(number == null || number.length() == 0) return;
		print("", number, 0);
	}
	
	public static void print(String prefix, String number, int index) {
		if(index >= number.length()) {
			System.out.println(prefix);
			return;
		}
		char current = number.charAt(index);
		String mapStr = map.get(""+current);
		for(char c: mapStr.toCharArray()) {
			print(prefix+c, number, index+1);
		}
	}
}
