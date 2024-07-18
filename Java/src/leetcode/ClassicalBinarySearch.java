package leetcode;

class ClassicalBinarySearch {
	int binarySearch(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ClassicalBinarySearch lzr = new ClassicalBinarySearch();
		int[] arr = { 1, 2, 4, 5, 7, 8, 9 };
		int target = 4;
		int res = lzr.binarySearch(arr, target);
		System.out.print(res);
	}
}