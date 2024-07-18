package Code;

class LeastMovesToAscendingArray {
	int leastMoves(int[] arr) {
		int[] tails = new int[arr.length];
		int len = 0;
		for (int num : arr) {
			int left = 0, right = len;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (tails[mid] < num) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			tails[left] = num;
			if (left == len) {
				len++;
			}
		}
		return arr.length - len;
	}

	public static void main(String[] args) {
		LeastMovesToAscendingArray lzr = new LeastMovesToAscendingArray();
		int[] arr = { 1, 5, 9, 3, 6, 8 };
		int res = lzr.leastMoves(arr);
		System.out.print(res);
	}
}