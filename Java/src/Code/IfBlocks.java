package Code;

import java.util.ArrayList;
import java.util.List;

class IfBlocks {
	List<String> ifBlocks(int n) {
		List<String> res = new ArrayList<String>();
		char[] cur = new char[n * 2];
		dfs(cur, n, n, 0, res);
		return res;
	}

	void dfs(char[] cur, int left, int right, int idx, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(new String(cur));
			return;
		}
		if (left > 0) {
			cur[idx] = '{';
			dfs(cur, left - 1, right, idx + 1, res);
		}
		if (right > left) {
			cur[idx] = '}';
			dfs(cur, left, right - 1, idx + 1, res);
		}
	}

	public static void main(String[] args) {
		IfBlocks lzr = new IfBlocks();
		List<String> res = new ArrayList<>();
		res = lzr.ifBlocks(2);
		System.out.print(res);
	}
}