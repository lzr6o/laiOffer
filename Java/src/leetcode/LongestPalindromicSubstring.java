package leetcode;

class LongestPalindromicSubstring {
	String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int head = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			int cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
			if (cur > max) {
				max = cur;
				head = i - (cur - 1) / 2;
			}
		}
		return s.substring(head, head + max);
	}

	int getLen(String str, int left, int right) {
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lzr = new LongestPalindromicSubstring();
		String s = "babad";
		String res = lzr.longestPalindrome(s);
		System.out.print(res);
	}
}