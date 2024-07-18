package Code;

import java.util.HashSet;
import java.util.Set;

class DictionaryWord {

	boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = toSet(dict);
		boolean[] canBreak = new boolean[input.length() + 1];
		canBreak[0] = true;
		for (int i = 1; i < canBreak.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dictSet.contains(input.substring(j, i)) && canBreak[j]) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[canBreak.length - 1];
	}
	
	Set<String> toSet(String[] dict) {
		Set<String> set = new HashSet<>();
		for (String s : dict) {
			set.add(s);
		}
		return set;
	}
	
	public static void main(String[] args) {
		DictionaryWord lzr = new DictionaryWord();
		String input = "robcatd";
		String[] dict = { "rob", "cat", "d" };
		boolean result = lzr.canBreak(input, dict);
		System.out.print(result);
	}
}