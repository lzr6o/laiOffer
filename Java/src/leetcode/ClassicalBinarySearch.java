package leetcode;

class ClassicalBinarySearch {

	int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ClassicalBinarySearch lzr = new ClassicalBinarySearch();
		int[] array = { 1, 2, 4, 5, 7, 8, 9 };
		int target = 4;
		int result = lzr.binarySearch(array, target);
		System.out.print(result);
	}
}