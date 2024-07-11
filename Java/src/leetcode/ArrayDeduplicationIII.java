package leetcode;

import java.util.Arrays;

class ArrayDeduplicationIII {
	int[] dedup(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int end = 0;
		boolean flag = false;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[end]) {
				flag = true;
			} else if (flag) {
				array[end] = array[i];
				flag = false;
			} else {
				array[++end] = array[i];
			}
		}
		return Arrays.copyOf(array, flag ? end : end + 1);
	}

	public static void main(String[] args) {
		ArrayDeduplicationIII lzr = new ArrayDeduplicationIII();
		int[] array = { 1, 2, 2, 3, 3, 3, 4 };
		int[] result = lzr.dedup(array);
		System.out.print(Arrays.toString(result));
	}
}