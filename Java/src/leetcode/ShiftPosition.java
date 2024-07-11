package leetcode;
class ShiftPosition {
	int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < array[right]) {
				right = mid;
			} else if (array[mid] > array[right]){
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		ShiftPosition lzr = new ShiftPosition();
		int[] array = { 4, 1, 2, 3 };
		int result = lzr.shiftPosition(array);
		System.out.print(result);
	}
}