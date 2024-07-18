package Code;

import java.util.Arrays;

class ArrayDeduplicationV {

	int[] dedup(int[] arr) {
		if (arr.length <= 2) {
			return arr;
		}
		int slow = 2;
		for (int fast = 2; fast < arr.length; fast++) {
			if (arr[fast] != arr[slow - 1] || arr[fast] != arr[slow - 2]) {
				arr[slow++] = arr[fast];
			}
		}
		return Arrays.copyOf(arr, slow);
	}

	public static void main(String[] args) {
		ArrayDeduplicationV lzr = new ArrayDeduplicationV();
		int[] array = { 1, 1, 1, 1 };
		int[] result = lzr.dedup(array);
		System.out.print(Arrays.toString(result));
	}
}