package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TwoSumAllPairII {
	List<List<Integer>> allPairs(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1) {
				res.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				res.add(Arrays.asList(target - num, num));
			}
			if (count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TwoSumAllPairII lzr = new TwoSumAllPairII();
		int[] arr = {2, 1, 3, 2, 4, 3, 4, 2};
		int target = 6;
		List<List<Integer>> res = lzr.allPairs(arr, target);
		System.out.print(res);
	}
}