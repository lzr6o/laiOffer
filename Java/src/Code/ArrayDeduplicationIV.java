package Code;

import java.util.Arrays;

class ArrayDeduplicationIV {

	int[] dedup(int[] arr) {
		int end = -1;
		for (int i = 0; i < arr.length; i++) {
			if (end == -1 || arr[i] != arr[end]) {
				arr[++end] = arr[i];
			} else {
				while (i + 1 < arr.length && arr[i + 1] == arr[end]) {
					i++;
				}
				end--;
			}
		}
		return Arrays.copyOf(arr, end + 1);
	}
	
	public static void main(String[] args) {
		ArrayDeduplicationIV lzr = new ArrayDeduplicationIV();
		int[] arr = { 1, 2, 3, 3, 3, 2, 2 };
		int[] res = lzr.dedup(arr);
		System.out.print(Arrays.toString(res));
	}
}