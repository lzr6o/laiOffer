package leetcode;

import java.util.ArrayList;
import java.util.List;

class FindKClosestElements {
	List<Integer> findClosestElements(int[] arr, int k, int x) {
		int left = 0, right = arr.length - k;
		while (left < right) {
			int mid = (left + right) / 2;
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		List<Integer> res = new ArrayList<>(k);
		for (int i = left; i < left + k; i++) {
			res.add(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		FindKClosestElements lzr = new FindKClosestElements();
		int[] arr = { 1, 3 };
		int k = 1;
		int x = 2;
		List<Integer> res = lzr.findClosestElements(arr, k, x);
		System.out.print(res);
	}
}