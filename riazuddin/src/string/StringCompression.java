package string;
/*
 * Given string compress it with each characters' char count if its > 1
 * 
 * Example: Give ddddcccaaadda, then output 4d3c3a2da
 */
public class StringCompression {
	
	public static void main(String[] args) {
		System.out.println(compress("ddddcccaaadda"));
		System.out.println(compress("dcaaaaaaaada"));
	}
	
	public static String compress(String input) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char now = input.charAt(0), prev = now;
		
		for(int i = 1; i < input.length(); i++) {
			now = input.charAt(i);
			if(now != prev) {
				if(count > 1)
					sb.append(count);
				sb.append(prev);
				
				count = 1;
				prev = now;
			}else {
				count++;
			}
		}
		if(count > 1)
			sb.append(count);
		sb.append(now);
		
		return sb.toString();
	}

}
