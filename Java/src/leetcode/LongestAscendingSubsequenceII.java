package leetcode;
import java.util.Arrays;

class LongestAscendingSubsequenceII {
	int[] longest(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int[] tails = new int[arr.length];
		int[] idx = new int[arr.length];
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			int left = 0;
			int right = len;
			while (left != right) {
				int mid = left + (right - left) / 2;
				if (tails[mid] < arr[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			tails[left] = arr[i];
			idx[i] = left + 1;
			if (left == len) {
				len++;
			}
		}
		int[] res = new int[len];
		int tail = tails[len - 1] + 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < tail && idx[i] == len) {
				res[--len] = arr[i];
				tail = arr[i];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequenceII lzr = new LongestAscendingSubsequenceII();
		int[] arr = { 5, 2, 6, 3, 4, 7, 5, 1 };
		int[] res = lzr.longest(arr);
		System.out.print(Arrays.toString(res));
	}
}