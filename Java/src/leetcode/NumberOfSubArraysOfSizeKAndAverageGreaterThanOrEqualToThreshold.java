package leetcode;

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
	int numOfSubarrays(int[] arr, int k, int threshold) {
		int l = 0, r = 0, sum = 0, cnt = 0;
		while (r < arr.length) {
			sum += arr[r++];
			if (r - l > k - 1) {
				if (sum / k >= threshold) {
					cnt++;
				}
				sum -= arr[l++];
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold lzr = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold();
		int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
		int k = 3;
		int threshold = 4;
		int res = lzr.numOfSubarrays(arr, k, threshold);
		System.out.print(res);
	}
}