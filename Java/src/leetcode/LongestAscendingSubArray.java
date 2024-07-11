package leetcode;

class LongestAscendingSubArray {
	int longest(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int result = 1;
		int cur = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				cur++;
				result = Math.max(result, cur);
			} else {
				cur = 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubArray lzr = new LongestAscendingSubArray();
		int[] array = { 7, 2, 3, 1, 5, 8, 9, 6 };
		int result = lzr.longest(array);
		System.out.print(result);
	}
}