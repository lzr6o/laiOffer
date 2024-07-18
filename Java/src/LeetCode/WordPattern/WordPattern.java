package LeetCode.WordPattern;
import java.util.HashMap;
import java.util.Map;

class WordPattern {
	boolean wordPattern(String pattern, String s) {
		Map<Character, String> map = new HashMap<>();
		String[] words = s.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(words[i])) {
					return false;
				}
			} else {
				if (map.containsValue(words[i])) {
					return false;
				}
				map.put(c, words[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern lzr = new WordPattern();
		String pattern = "abba";
		String s = "dog cat cat fish";
		boolean res = lzr.wordPattern(pattern, s);
		System.out.print(res);
	}
}