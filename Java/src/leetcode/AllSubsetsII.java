package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllSubsetsII {
	List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, res);
		return res;
	}
	
	void helper(char[] set, StringBuilder sb, int idx, List<String> res) {
		if (idx == set.length) {
			res.add(sb.toString());
			return;
		}
		helper(set, sb.append(set[idx]), idx + 1, res);
		sb.deleteCharAt(sb.length() - 1);
		while (idx < set.length - 1 && set[idx] == set[idx + 1]) {
			idx++;
		}
		helper(set, sb, idx + 1, res);
	}
	
	public static void main(String[] args) {
		AllSubsetsII lzr = new AllSubsetsII();
		String set = "abbbc";
		List<String> res = new ArrayList<>();
		res = lzr.subSets(set);
		System.out.print(res);
	}
}