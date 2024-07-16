package leetcode;

import java.util.List;

class FindKClosestElements {
	List<Integer> findClosestElements(int[] arr, int k, int x) {
		
	}

	public static void main(String[] args) {
		FindKClosestElements lzr = new FindKClosestElements();
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;
		List<Integer> res = lzr.findClosestElements(arr, k, x);
		System.out.print(res);
	}
}