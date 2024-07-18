package Code;

import java.util.ArrayList;
import java.util.List;

class AllSubsetsOfSizeK {

	List<String> subSetsOfSizeK(String set, int k) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arraySet = set.toCharArray();
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
		helper(set, k, sb, idx + 1, res);
		helper(set, k, sb.append(set[idx]), idx + 1, res);
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public static void main(String[] args) {
		AllSubsetsOfSizeK lzr = new AllSubsetsOfSizeK();
		String set = "abcd";
		int k = 2;
		List<String> res = new ArrayList<>();
		res = lzr.subSetsOfSizeK(set, k);
		System.out.print(res);
	}
}