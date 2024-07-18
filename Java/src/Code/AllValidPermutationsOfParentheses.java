package Code;

import java.util.ArrayList;
import java.util.List;

class AllValidPermutationsOfParentheses {

	List<String> validParentheses(int k) {
		List<String> res = new ArrayList<>();
		char[] cur = new char[k * 2];
		dfs(cur, k, k, 0, res);
		return res;
	}

	void dfs(char[] cur, int left, int right, int idx, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(new String(cur));
			return;
		}
		if (left > 0) {
			cur[idx] = '(';
			dfs(cur, left - 1, right, idx + 1, res);
		}
		if (right > left) {
			cur[idx] = ')';
			dfs(cur, left, right - 1, idx + 1, res);
		}
	}

	public static void main(String args[]) {
		AllValidPermutationsOfParentheses lzr = new AllValidPermutationsOfParentheses();
		List<String> res = lzr.validParentheses(3);
		System.out.print(res);
	}
}