package leetcode;

import java.util.HashSet;
import java.util.Set;

class AllUniqueCharacters {

	boolean allUnique(String word) {
		Set<Character> set = new HashSet<>();
		char[] str = word.toCharArray();
		for (char s : str) {
			if (!set.contains(s)) {
				set.add(s);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		AllUniqueCharacters lzr = new AllUniqueCharacters();
		String word = "aba";
		boolean res = lzr.allUnique(word);
		System.out.print(res);
	}
}