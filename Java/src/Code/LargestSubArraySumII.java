package Code;

import java.util.Arrays;

class LargestSubArraySumII {
	int[] largestSum(int[] arr) {
		int max = arr[0], cur = arr[0];
		int head = 0, tail = 0;
		int[] res = new int[3];
		res[0] = max;
		res[1] = head;
		res[2] = tail;
		for (int i = 1; i < arr.length; i++) {
			if (cur + arr[i] > arr[i]) {
				cur += arr[i];
				tail++;
			} else {
				cur = arr[i];
				head = i;
				tail = i;
			}
			if (cur > max) {
				max = cur;
				res[0] = max;
				res[1] = head;
				res[2] = tail;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LargestSubArraySumII lzr = new LargestSubArraySumII();
		int[] arr = { -1 };
		int[] res = lzr.largestSum(arr);
		System.out.print(Arrays.toString(res));
	}
}