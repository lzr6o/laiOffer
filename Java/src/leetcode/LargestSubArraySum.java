package leetcode;
class LargestSubArraySum {
	int largestSum(int[] array) {
		int result = array[0], cur = array[0];
		for (int i = 1; i < array.length; i++) {
			cur = Math.max(cur + array[i], array[i]);
			result = Math.max(result, cur);
		}
		return result;
	}
	
	public static void main(String[] args) {
		LargestSubArraySum lzr = new LargestSubArraySum();
		int[] array = { 2, -1, 4, -2, 1 };
		int result = lzr.largestSum(array);
		System.out.print(result);
	}
}