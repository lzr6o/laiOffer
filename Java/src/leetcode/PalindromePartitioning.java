package leetcode;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
	List<List<String>> res;
	List<String> part;

	List<List<String>> partition(String s) {
		res = new ArrayList<>();
		part = new ArrayList<>();
		dfs(s, 0);
		return res;
	}

	void dfs(String s, int idx) {
		if (idx == s.length()) {
			res.add(new ArrayList<>(part));
			return;
		}
		for (int i = idx; i < s.length(); i++) {
			if (isPali(s, idx, i)) {
				part.add(s.substring(idx, i + 1));
				dfs(s, i + 1);
				part.remove(part.size() - 1);
			}
		}
	}

	boolean isPali(String str, int left, int right) {
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning lzr = new PalindromePartitioning();
		String s = "aab";
		List<List<String>> res = lzr.partition(s);
		System.out.print(res);
	}
}