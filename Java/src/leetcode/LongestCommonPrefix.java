package leetcode;

class LongestCommonPrefix {
	String longestCommonPrefix(String[] strs) {
		StringBuilder pre = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			for (String str : strs) {
				if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) {
					return pre.toString();
				}	
			}
			pre.append(strs[0].charAt(i));
		}
		return pre.toString();
	}

	public static void main(String[] args) {
		LongestCommonPrefix lzr = new LongestCommonPrefix();
		String[] strs = { "ab", "ab", "ac" };
		String res = lzr.longestCommonPrefix(strs);
		System.out.print(res);
	}
}