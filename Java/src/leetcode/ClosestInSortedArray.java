package leetcode;

class ClosestInSortedArray {
	int closest(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
			return left;
		}
		return right;
	}
	
	public static void main(String[] args) {
		ClosestInSortedArray lzr = new ClosestInSortedArray();
		int[] arr = { 1, 2, 3, 8, 9 };
		int target = 4;
		int res = lzr.closest(arr, target);
		System.out.print(res);
	}
}