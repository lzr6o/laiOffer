package leetcode;

import java.util.HashMap;
import java.util.Map;

class IsomorphicStrings {
	boolean isomorphic(String s, String t) {
		Map<Character, Character> mapS = new HashMap<>(), mapT = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c1 = s.charAt(i), c2 = t.charAt(i);
			if ((mapS.containsKey(c1) && mapS.get(c1) != c2) || (mapT.containsKey(c2) && mapT.get(c2) != c1)) {
				return false;
			}
			mapS.put(c1, c2);
			mapT.put(c2, c1);
		}
		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings lzr = new IsomorphicStrings();
		String s = "badc";
		String t = "baba";
		boolean res = lzr.isomorphic(s, t);
		System.out.print(res);
	}
}