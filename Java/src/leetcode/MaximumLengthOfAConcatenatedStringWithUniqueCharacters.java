package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	int maxLength(List<String> arr) {
		return dfs(arr, "", 0);
	}

	int dfs(List<String> arr, String str, int idx) {
		if (idx == arr.size()) {
			if (chk(str)) {
				return str.length();
			}
			return 0;
		}
		int pic = dfs(arr, str + arr.get(idx), idx + 1);
		int not = dfs(arr, str, idx + 1);
		return Math.max(pic, not);
	}

	boolean chk(String s) {
		Set<Character> set = new HashSet<>();
		for (Character c : s.toCharArray()) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MaximumLengthOfAConcatenatedStringWithUniqueCharacters lzr = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
		List<String> arr = Arrays.asList("un","iq","ue");
		int res = lzr.maxLength(arr);
		System.out.print(res);
	}
}