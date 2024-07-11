package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SwapForLongestRepeatedCharacterSubstring {
	int maxRepOpt1(String text) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			char cur = text.charAt(i);
			if (!map.containsKey(cur)) {
				map.put(cur, new ArrayList<>());
			}
			map.get(cur).add(i);
		}
		int res = 0;
		for (List<Integer> indices : map.values()) {
			int cur, pre, sum;
			cur = 1;
			pre = sum = 0;
			for (int j = 1; j < indices.size(); j++) {
				if (indices.get(j) == indices.get(j - 1) + 1) {
					cur++;
				} else {
					pre = indices.get(j) == indices.get(j - 1) + 2 ? cur : 0;
					cur = 1;
				}
				sum = Math.max(sum, pre + cur);
			}
			res = Math.max(res, sum + (sum < indices.size() ? 1 : 0));
		}
		return res;
	}

	public static void main(String[] args) {
		SwapForLongestRepeatedCharacterSubstring lzr = new SwapForLongestRepeatedCharacterSubstring();
		String text = "ababa";
		int res = lzr.maxRepOpt1(text);
		System.out.print(res);
	}
}