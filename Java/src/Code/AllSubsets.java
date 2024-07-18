package Code;

import java.util.ArrayList;
import java.util.List;

class AllSubsets {
	List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arr = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		dfs(arr, sb, 0, res);
		return res;
	}

	void dfs(char[] arr, StringBuilder sb, int idx, List<String> res) {
		if (idx == arr.length) {
			res.add(sb.toString());
			return;
		}
		dfs(arr, sb, idx + 1, res);
		dfs(arr, sb.append(arr[idx]), idx + 1, res);
		sb.deleteCharAt(sb.length() - 1);
	}

	public static void main(String args[]) {
		AllSubsets lzr = new AllSubsets();
		String set = "abc";
		List<String> res = lzr.subSets(set);
		System.out.print(res);
	}
}