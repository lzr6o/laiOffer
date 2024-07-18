package Code;

import java.util.Arrays;

class ArrayDeduplication {

	int[] dedup(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int end = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[end]) {
				arr[++end] = arr[i];
			}
		}
		return Arrays.copyOf(arr, end + 1);
	}
	
	public static void main(String[] args) {
		ArrayDeduplication lzr = new ArrayDeduplication();
		int[] arr = { 1, 2, 2, 3, 3, 3 };
		int[] res = lzr.dedup(arr);
		System.out.print(Arrays.toString(res));
	}
}