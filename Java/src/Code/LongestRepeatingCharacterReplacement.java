package Code;

class LongestRepeatingCharacterReplacement {
	int characterReplacement(String s, int k) {
		int[] cnt = new int[26];
		char[] arr = s.toCharArray();
		int L = 0, R = 0, max = Integer.MIN_VALUE;
		while (R < s.length()) {
			cnt[arr[R] - 'A']++;
			max = Math.max(max, cnt[arr[R] - 'A']);
			while (R - L - max > k - 1) {
				cnt[arr[L++] - 'A']--;
			}
			R++;
		}
		return s.length() - L;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement lzr = new LongestRepeatingCharacterReplacement();
		String s = "AABABBA";
		int k = 1;
		int res = lzr.characterReplacement(s, k);
		System.out.print(res);
	}
}