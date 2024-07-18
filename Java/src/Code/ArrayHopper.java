package Code;

class ArrayHopper {

	boolean canJump(int[] arr) {
		if (arr.length == 1) {
			return true;
		}
		boolean[] dp = new boolean[arr.length];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (i + arr[i] >= arr.length - 1) {
				dp[i] = true;
			} else {
				for (int j = arr[i]; j >= 1; j--) {
					if (dp[j + i]) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		ArrayHopper lzr = new ArrayHopper();
		int[] arr = { 2, 3, 1, 1, 4 };
		boolean res = lzr.canJump(arr);
		System.out.print(res);
	}
}