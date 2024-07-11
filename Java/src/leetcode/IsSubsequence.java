package leetcode;

class IsSubsequence {

	boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length() ? true : false;
	}

	public static void main(String[] args) {
		IsSubsequence lzr = new IsSubsequence();
		String s = "b";
		String t = "c";
		boolean res = lzr.isSubsequence(s, t);
		System.out.print(res);
	}
}