package Code;

class LongestAscendingSubsequence {
	int longest(int[] arr) {
		int[] tails = new int[arr.length];
		int size = 0;
		for (int num : arr) {
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
		LongestAscendingSubsequence lzr = new LongestAscendingSubsequence();
		int[] arr = { 5, 2, 6, 3, 4, 7, 5 };
		int res = lzr.longest(arr);
		System.out.print(res);
	}
}