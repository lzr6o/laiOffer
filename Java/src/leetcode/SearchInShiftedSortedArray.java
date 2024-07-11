package leetcode;
class SearchInShiftedSortedArray {
	int search(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] > array[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		int rot = left;
		left = 0;
		right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int realMid = (mid + rot) % array.length;
			if (array[realMid] == target) {
				return realMid;
			} else if (array[realMid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInShiftedSortedArray lzr = new SearchInShiftedSortedArray();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int result = lzr.search(nums, target);
		System.out.print(result);
	}
}
