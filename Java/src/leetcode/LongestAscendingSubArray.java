package leetcode;

class LongestAscendingSubArray {
	int longest(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int res = 1, cur = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				cur++;
				res = Math.max(res, cur);
			} else {
				cur = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LongestAscendingSubArray lzr = new LongestAscendingSubArray();
		int[] arr = { 7, 2, 3, 1, 5, 8, 9, 6 };
		int res = lzr.longest(arr);
		System.out.print(res);
	}
}