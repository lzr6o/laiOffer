package Code;

class LongestSubstringWithAtLeastKRepeatingCharacters {
	int longestSubstring(String s, int k) {
		return dfs(s.toCharArray(), 0, s.length(), k);
	}

	int dfs(char[] str, int start, int end, int k) {
		if (end - start < k) {
			return 0;
		}
		int[] cnt = new int[26];
		for (int i = start; i < end; i++) {
			int idx = str[i] - 'a';
			cnt[idx]++;
		}
		for (int i = 0; i < 26; i++) {
			if (cnt[i] < k && cnt[i] > 0) {
				for (int j = start; j < end; j++) {
					if (str[j] == i + 'a') {
						int left = dfs(str, start, j ,k);
						int right = dfs(str, j + 1, end, k);
						return Math.max(left, right);
					}
				}
			}
		}
		return end - start;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters lzr = new LongestSubstringWithAtLeastKRepeatingCharacters();
		String s = "bbaaacbd";
		int k = 3;
		int res = lzr.longestSubstring(s, k);
		System.out.print(res);
	}
}