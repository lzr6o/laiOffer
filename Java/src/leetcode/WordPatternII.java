package leetcode;
import java.util.HashMap;
import java.util.Map;

class WordPatternII {
	boolean wordPatternMatch(String pattern, String s) {
		Map<Character, String> map = new HashMap<>();
		return dfs(map, pattern, s);
	}
	
	boolean dfs(Map<Character, String> map, String pattern, String s) {
		if (pattern.length() == 0) {
			return s.length() == 0;
		}
		char c = pattern.charAt(0);
		if (map.containsKey(c)) {
			if (!s.startsWith(map.get(c))) {
				return false;
			} else {
				return dfs(map, pattern.substring(1), s.substring(map.get(c).length()));
			}
		}
		for (int i = 0; i < s.length(); i++) {
			String word = s.substring(0, i + 1);
			if (map.containsValue(word)) {
				continue;
			}
			map.put(c, word);
			if (dfs(map, pattern.substring(1), s.substring(i + 1))) {
				return true;
			}
			map.remove(c);
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordPatternII lzr = new WordPatternII();
		String pattern = "abab";
		String s = "redblueredblue";
		boolean res = lzr.wordPatternMatch(pattern, s);
		System.out.print(res);
	}
}