package Code;

import java.util.Arrays;

class ArrayDeduplicationII {
	int[] dedup(int[] arr) {
		if (arr.length <= 2) {
			return arr;
		}
		int end = 1;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] != arr[end - 1]) {
				arr[++end] = arr[i];
			}
		}
		return Arrays.copyOf(arr, end + 1);
	}
	
	public static void main(String[] args) {
		ArrayDeduplicationII lzr = new ArrayDeduplicationII();
		int[] arr = { 1, 2, 2, 3, 3, 3 };
		int[] res = lzr.dedup(arr);
		System.out.print(Arrays.toString(res));
	}
}