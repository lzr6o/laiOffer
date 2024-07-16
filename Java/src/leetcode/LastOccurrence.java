package leetcode;

class LastOccurrence {
	int lastOccur(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int L = 0, R = arr.length - 1;
		while (L < R - 1) {
			int mid = L + (R - L) / 2;
			if (arr[mid] <= target) {
				L = mid;
			} else {
				R = mid;
			}
		}
		if (arr[R] == target) {
			return R;
		} else if (arr[L] == target) {
			return L;
		}
		return -1;
	}

	public static void main(String[] args) {
		LastOccurrence lzr = new LastOccurrence();
		int[] arr = { 4, 5, 5, 5, 5, 5, 5 };
		int target = 5;
		int res = lzr.lastOccur(arr, target);
		System.out.print(res);
	}
}