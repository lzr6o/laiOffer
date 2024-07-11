package leetcode;

class LongestSubarrayContainsOnly1s {
	int longestConsecutiveOnes(int[] nums, int k) {
		int slow = 0;
		int fast = 0;
		int count = 0;
		int longest = 0;
		while (fast < nums.length) {
			if (nums[fast] == 1) {
				longest = Math.max(longest, ++fast - slow);
			} else if (count < k) {
				count++;
				longest = Math.max(longest, ++fast - slow);
			} else if (nums[slow++] == 0) {
				count--;
			}
		}
		return longest;
	}
	
	public static void main(String args[]) {
		LongestSubarrayContainsOnly1s lzr = new LongestSubarrayContainsOnly1s();
		int[] nums = { 1, 1, 0, 0, 0, 0, 0 };
		int k = 2;
		int res = lzr.longestConsecutiveOnes(nums, k);
		System.out.print(res);
	}
}