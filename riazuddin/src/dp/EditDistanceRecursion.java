package dp;
/*
 * Given source and target strings. How many edits are required to convert source to target string.
 * an edit at a time can be insert, delete or replace.
 * 
 */
public class EditDistanceRecursion {

	public static void main(String[] args) {
		String s = "cut", t = "cat";
		System.out.println(editDistance(s, t, s.length() - 1, t.length() - 1));
	}
	static int editDistance(String s, String t, int sl, int tl) {
		if(sl == 0) return tl;
		if(tl == 0) return sl;
		
		if(s.charAt(sl) == t.charAt(tl)) 
			return editDistance(s, t, sl - 1, tl - 1);
		
		int delete = editDistance(s, t, sl-1, tl), insert = editDistance(s, t, sl, tl-1), replace = editDistance(s, t, sl-1, tl - 1);
//		System.out.println(delete+" "+insert+" "+replace);
		return 1 + Math.min(delete, Math.min(insert, replace));
	}
}
