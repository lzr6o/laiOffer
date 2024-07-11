package leetcode;

class FirstOccurrence {

	int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (array[left] == target) {
			return left;
		} else if (array[right] == target) {
			return right;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		FirstOccurrence lzr = new FirstOccurrence();
		int[] array = { 1, 2, 2, 2, 3 };
		int target = 2;
		int result = lzr.firstOccur(array, target);
		System.out.print(result);
	}
}