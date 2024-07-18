package Code;

class FindPeakElement {

	int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid - 1] > nums[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return nums[left] > nums[right] ? left : right;
	}
	
	public static void main(String[] args) {
		FindPeakElement lzr = new FindPeakElement();
		int[] nums = { 1, 2 };
		int res = lzr.findPeakElement(nums);
		System.out.print(res);
	}
}