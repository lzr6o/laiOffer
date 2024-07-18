package Code;

import java.util.Arrays;
import java.util.List;

class WordBreak {
	boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[n] = true;
		for (int i = n; i >= 0; i--) {
			for (String word : wordDict) {
				if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
					dp[i] = dp[i + word.length()];
				}
				if (dp[i]) {
					break;
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		WordBreak lzr = new WordBreak();
		String s = "abcd";
		List<String> wordDict = Arrays.asList("a", "abc", "b", "cd");
		boolean res = lzr.wordBreak(s, wordDict);
		System.out.print(res);
	}
}