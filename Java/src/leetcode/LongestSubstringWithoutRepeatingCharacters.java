package leetcode;

class LongestSubstringWithoutRepeatingCharacters {
	int lengthOfLongestSubstring(String s) {
		int[] cnt = new int[128];
		int L = 0, R = 0, max = 0;
		while (R < s.length()) {
			if (cnt[s.charAt(R)] == 0) {
				cnt[s.charAt(R)]++;
				max = Math.max(max, ++R - L);
			} else {
				cnt[s.charAt(L++)]--;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		LongestSubstringWithoutRepeatingCharacters lzr = new LongestSubstringWithoutRepeatingCharacters();
		String input = "bcdfbd";
		int res = lzr.lengthOfLongestSubstring(input);
		System.out.print(res);
	}
}