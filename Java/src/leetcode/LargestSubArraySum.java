package leetcode;

class LargestSubArraySum {
	int largestSum(int[] arr) {
		int res = arr[0], cur = arr[0];
		for (int i = 1; i < arr.length; i++) {
			cur = Math.max(cur + arr[i], arr[i]);
			res = Math.max(res, cur);
		}
		return res;
	}

	public static void main(String[] args) {
		LargestSubArraySum lzr = new LargestSubArraySum();
		int[] arr = { 2, -1, 4, -2, 1 };
		int res = lzr.largestSum(arr);
		System.out.print(res);
	}
}