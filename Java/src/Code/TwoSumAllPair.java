package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TwoSumAllPair {
	List<List<Integer>> allPairs(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> indices = map.get(target - arr[i]);
			if (indices != null) {
				for (int j : indices) {
					res.add(Arrays.asList(j, i));
				}
			}
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<Integer>());
			}
			map.get(arr[i]).add(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		TwoSumAllPair lzr = new TwoSumAllPair();
		int[] arr = {1, 3, 3, 2, 2};
		int target = 5;
		List<List<Integer>> result = lzr.allPairs(arr, target);
		System.out.print(result);
	}
}