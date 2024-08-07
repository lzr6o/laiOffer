package Code;

class LongestConsecutive1s {
	int longest(int[] arr) {
		int res = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				cnt++;
			} else {
				cnt = 0;
			}
			res = Math.max(res, cnt);
		}
		return res;
	}

	public static void main(String[] args) {
		LongestConsecutive1s lzr = new LongestConsecutive1s();
		int[] arr = { 0, 1, 0, 1, 1, 1, 0 };
		int res = lzr.longest(arr);
		System.out.print(res);
	}
}