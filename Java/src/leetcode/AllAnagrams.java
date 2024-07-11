package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllAnagrams {

	List<Integer> allAnagrams(String s, String l) {
		List<Integer> res = new ArrayList<>();
		if (l.length() == 0) {
			return res;
		}
		if (s.length() > l.length()) {
			return res;
		}
		Map<Character, Integer> map = countMap(s);
		int match = 0;
		for (int i = 0; i < l.length(); i++) {
			char tmp = l.charAt(i);
			Integer cnt = map.get(tmp);
			if (cnt != null) {
				map.put(tmp, cnt - 1);
				if (cnt == 1) {
					match++;
				}
			}
			if (i >= s.length()) {
				tmp = l.charAt(i - s.length());
				cnt = map.get(tmp);
				if (cnt != null) {
					map.put(tmp, cnt + 1);
					if (cnt == 0) {
						match--;
					}
				}
			}
			if (match == map.size()) {
				res.add(i - s.length() + 1);
			}
		}
		return res;
	}
	
	Map<Character, Integer> countMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			Integer cnt = map.get(ch);
			if (cnt == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, cnt + 1);
			}
		}
		return map;
	}
	
	public static void main(String args[]) {
		AllAnagrams lzr = new AllAnagrams();
		String s = "ab";
		String l = "abcbac";
		List<Integer> res = new ArrayList<>();
		res = lzr.allAnagrams(s, l);
		System.out.print(res);
	}
}