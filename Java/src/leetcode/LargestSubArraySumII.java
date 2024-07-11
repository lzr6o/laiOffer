package leetcode;
import java.util.Arrays;

class LargestSubArraySumII {
	int[] largestSum(int[] array) {
		int max = array[0], cur = array[0];
		int head = 0, tail = 0;
		int[] result = new int[3];
		result[0] = max;
		result[1] = head;
		result[2] = tail;
		for (int i = 1; i < array.length; i++) {
			if (cur + array[i] > array[i]) {
				cur += array[i];
				tail++;
			} else {
				cur = array[i];
				head = i;
				tail = i;
			}
			if (cur > max) {
				max = cur;
				result[0] = max;
				result[1] = head;
				result[2] = tail;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LargestSubArraySumII lzr = new LargestSubArraySumII();
		int[] array = { -1 };
		int[] result = lzr.largestSum(array);
		System.out.print(Arrays.toString(result));
	}
}