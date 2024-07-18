package Code;
class TotalOccurrence {
	int totalOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		int res = 0;
		if (array[left] != target && array[right] != target) {
			return 0;
		}
		int start = array[left] == target ? left : right;
		while (start < array.length && array[start] == target) {
			res++;
			start++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		TotalOccurrence lzr = new TotalOccurrence();
		int[] array = { 1, 2 };
		int target = 0;
		int result = lzr.totalOccurrence(array, target);
		System.out.print(result);
	}
}