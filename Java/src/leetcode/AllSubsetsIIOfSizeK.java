package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllSubsetsIIOfSizeK {
	List<String> subSetsIIOfSizeK(String set, int k) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, k, sb, 0, res);
		return res;
	}
	
	void helper(char[] set, int k, StringBuilder sb, int idx, List<String> res) {
		if (sb.length() == k) {
			res.add(sb.toString());
			return;
		}
		if (idx == set.length) {
			return;
		}
		helper(set, k, sb.append(set[idx]), idx + 1, res);
		sb.deleteCharAt(sb.length() - 1);
		while (idx < set.length - 1 && set[idx] == set[idx + 1]) {
			idx++;
		}
		helper(set, k, sb, idx + 1, res);
	}
	
	public static void main(String[] args) {
		AllSubsetsIIOfSizeK lzr = new AllSubsetsIIOfSizeK();
		String set = "abab";
		int k = 2;
		List<String> res = new ArrayList<>();
		res = lzr.subSetsIIOfSizeK(set, k);
		System.out.print(res);
	}
}