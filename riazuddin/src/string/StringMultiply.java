package string;

import java.util.ArrayList;
import java.util.List;

/*
 * Given 2 string with only integers in it. multiply them
 */
public class StringMultiply {
	
	public static void main(String[] args) {
		System.out.println(multiply("335", "43"));
	}

	public static String multiply(String s1, String s2) {
		
		//multiply each int from small number with big number
		String small = null, big = null;
		if(s2.length() <= s1.length()) {
			small = s2;
			big = s1;
		}else {
			small = s1; big = s2;
		}
		
		List<String> l = new ArrayList<>();
		for(int idx1=small.length() - 1; idx1 >=0; idx1--) {
			
			int s1Int = Character.getNumericValue(small.charAt(idx1));
			
			StringBuilder sb = new StringBuilder();
			int carry = 0;
			for(int idx2 = big.length() - 1; idx2 >= 0; idx2--) {
				int s2Int = Character.getNumericValue(big.charAt(idx2));
				int mult = s1Int * s2Int + carry;
				
				if(mult > 9) {
					int mod = mult % 10;
					carry = mult / 10;
					sb.insert(0, mod);
				} else {
					sb.insert(0, mult);
					carry = 0;
				}
			}
			if(carry > 0)
				sb.insert(0, carry);
			//store each mult result in list
			l.add(sb.toString());
		}
		
		//now add the results.
		/*
		 * Now, add the results i.e.,
		 * 335 * 43 =
		 * 335 * 3 * Math.pow(10,0) + 335 * 4 * Math.pow(10,1) = 14405
		 */
		int result = 0;
		int tab = 0;
		for(String s : l) {
			double num = Integer.parseInt(s) * Math.pow(10, tab);
			result += num;
			tab++;
		}
		return Integer.toString(result);
	}
}
