package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
	List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] arr = new char[26];
			for (char c : str.toCharArray()) {
				arr[c - 'a']++;
			}
			String key = String.valueOf(arr);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		GroupAnagrams lzr = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = lzr.groupAnagrams(strs);
		System.out.print(res);
	}
}