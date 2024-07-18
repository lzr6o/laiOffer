package Code;

class BinarySearch {

	int search(int[] nums, int target) {
		int L = 0, R = nums.length - 1;
		while (L <= R) {
			int M = L + (R - L) / 2;
			if (nums[M] == target) {
				return M;
			} else if (nums[M] > target) {
				R = M - 1;
			} else {
				L = M + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch lzr = new BinarySearch();
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 4;
		int res = lzr.search(nums, target);
		System.out.print(res);
	}
}