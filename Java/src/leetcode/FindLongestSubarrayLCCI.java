package leetcode;

class FindLongestSubarrayLCCI {
	String[] findLongestSubarray(String[] arr) {
		int letters = 0, digits = 0;
		int[][] dp = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i].charAt(0))) {
				digits++;
				dp[i][0] = digits;
				dp[i][1] = letters;
			} else {
				letters++;
				dp[i][0] = digits;
				dp[i][1] = letters;
			}
		}
		return String[]
    }
	
	public static void main(String[] args) {
		FindLongestSubarrayLCCI lzr = new FindLongestSubarrayLCCI();
		String[] arr = { "A", "B", "1", "C", "1" };
		String[] res = lzr.findLongestSubarray(arr);
		System.out.print(res);
	}
}