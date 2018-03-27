package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreadRecBackTracking {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("mobile");
		dict.add("samsung");
		dict.add("sam");
		dict.add("sung");
		dict.add("man");
		dict.add("mango");
		dict.add("and");
		dict.add("go");
		dict.add("i");
		dict.add("love");
		dict.add("ice");
		dict.add("cream");
		String s = "ilovesamsung";
		
		wordBreak(s, 0, dict, new ArrayList<>());
	}
	
	static void wordBreak(String s, int start, Set<String> d, List<String> list) {
		if(start == s.length()) System.out.println(list);
		
		for (int i = start; i < s.length()+1; i++) {
			String sub = s.substring(start, i);
			if(d.contains(sub)) {
				List<String> l = new ArrayList<>();
				l.addAll(list);
				l.add(sub);
				wordBreak(s, i, d, l);
			}
		}
	}
}
