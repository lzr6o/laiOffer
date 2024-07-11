package leetcode;
import java.util.Arrays;

class KClosestInSortedArray {
	int[] kClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0) {	
			return array;
		}
		if (k == 0) {
			return new int[0];
		}
		int left = largestSmallerEqual(array, target);
		int right = left + 1;
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			if (right >= array.length || left >= 0 && target - array[left] <= array[right] - target) {
				result[i] = array[left--];
			} else {
				result[i] = array[right++];
			}
		}
		return result;
	}
	
	int largestSmallerEqual(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		if (array[right] <= target) {
			return right;
		}
		if (array[left] <= target) {
			return left;
		}
		return -1;
	}

	public static void main(String[] args) {
		KClosestInSortedArray lzr = new KClosestInSortedArray();
		int[] array = { 1, 2, 3, 8, 9 };
		int target = 4;
		int k = 4;
		int[] result = lzr.kClosest(array, target, k);
		System.out.print(Arrays.toString(result));
	}
}