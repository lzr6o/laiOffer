package leetcode;
class PalindromicSubstrings {
	int countSubstrings(String s) {
		int[] cnt = new int[1];
		for (int i = 0; i < s.length(); i++) {
			extendPalindrome(s, i, i, cnt);
			extendPalindrome(s, i, i + 1, cnt);
		}
		return cnt[0];
	}

	void extendPalindrome(String s, int left, int right, int[] cnt) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			cnt[0]++;
			left--;
			right++;
		}
	}

	public static void main(String[] args) {
		PalindromicSubstrings lzr = new PalindromicSubstrings();
		String s = "ababa";
		int res = lzr.countSubstrings(s);
		System.out.print(res);
	}
}