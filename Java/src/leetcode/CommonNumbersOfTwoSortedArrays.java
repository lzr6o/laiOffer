package leetcode;

import java.util.ArrayList;
import java.util.List;

class CommonNumbersOfTwoSortedArrays {
	List<Integer> common(int[] a, int[] b) {
		List<Integer> common = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				common.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return common;
	}

	public static void main(String args[]) {
		CommonNumbersOfTwoSortedArrays lzr = new CommonNumbersOfTwoSortedArrays();
		int[] a = { 1, 1, 2, 2, 3 };
		int[] b = { 1, 1, 2, 5, 6 };
		List<Integer> res = lzr.common(a, b);
		System.out.print(res);
	}
}