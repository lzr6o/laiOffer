package Code;

import java.util.HashMap;
import java.util.Map;

class FourSum {
	class Pair {
		int left;
		int right;

		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	boolean exist(int[] arr, int target) {
		Map<Integer, Pair> map = new HashMap<>();
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				int pairSum = arr[j] + arr[i];
				if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
					return true;
				}
				if (!map.containsKey(pairSum)) {
					map.put(pairSum, new Pair(j, i));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FourSum lzr = new FourSum();
		int[] arr = { 1, 2, 2, 3, 4 };
		int target = 9;
		boolean res = lzr.exist(arr, target);
		System.out.print(res);
	}
}