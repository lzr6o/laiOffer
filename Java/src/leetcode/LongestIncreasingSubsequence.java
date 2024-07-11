package leetcode;
class LongestIncreasingSubsequence {
	int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int num : nums) {
			int idx = binarySearch(tails, 0, size, num);
			tails[idx] = num;
			if (idx == size) {
				size++;
			}
		}
		return size;
	}

	int binarySearch(int[] tails, int lo, int hi, int target) {
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (tails[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lzr = new LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int res = lzr.lengthOfLIS(nums);
		System.out.print(res);
	}
}