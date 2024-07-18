package Code;

class BestSightseeingPair {

	int maxScoreSightseeingPair(int[] arr) {
		int max = Integer.MIN_VALUE;
		int left = 0;
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i] + arr[left] + left - i);
			if (arr[left] - arr[i] < i - left) {
				left = i;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		BestSightseeingPair lzr = new BestSightseeingPair();
		int[] values = { 3, 7, 2, 3 };
		int res = lzr.maxScoreSightseeingPair(values);
		System.out.print(res);
	}
}