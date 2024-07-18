package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CommonNumbersOfTwoArrays {
	List<Integer> common(int[] a, int[] b) {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> common = new ArrayList<Integer>();
		for (int num : a) {
			set.add(num);
		}
		for (int num : b) {
			if (set.contains(num)) {
				common.add(num);
			}
		}
		common.sort(null);
		return common;
	}

	public static void main(String args[]) {
		CommonNumbersOfTwoArrays lzr = new CommonNumbersOfTwoArrays();
		int[] a = { 1, 2, 3 };
		int[] b = { 3, 1, 4 };
		List<Integer> result = new ArrayList<Integer>();
		result = lzr.common(a, b);
		System.out.print(result);
	}
}