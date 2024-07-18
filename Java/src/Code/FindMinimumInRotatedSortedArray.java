package Code;

class FindMinimumInRotatedSortedArray {

	int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}
	
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray lzr = new FindMinimumInRotatedSortedArray();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int result = lzr.findMin(nums);
		System.out.print(result);
	}
}