package leetcode;
class DetermineIfOneStringIsAnothersSubstring {
	int strstr(String large, String small) {
		if (large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			if (equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}

	boolean equals(String large, int start, String small) {
		for (int i = 0; i < small.length(); i++) {
			if (large.charAt(i + start) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		DetermineIfOneStringIsAnothersSubstring lzr = new DetermineIfOneStringIsAnothersSubstring();
		String s1 = "abcde";
		String s2 = "cde";
		int result = lzr.strstr(s1, s2);
		System.out.print(result);
	}
}