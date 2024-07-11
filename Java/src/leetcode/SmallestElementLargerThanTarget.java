package leetcode;
class SmallestElementLargerThanTarget {
	int smallestElementLargerThanTarget(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if (array[left] > target) {
			return left;
		} else if (array[right] > target) {
			return right;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SmallestElementLargerThanTarget lzr = new SmallestElementLargerThanTarget();
		int[] array = { 1, 3, 4, 5, 8, 9 };
		int target = 7;
		int result = lzr.smallestElementLargerThanTarget(array, target);
		System.out.print(result);
	}
}