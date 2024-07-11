package leetcode;
import java.util.Arrays;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	int minDifference(int[] nums) {
		int n = nums.length;
		int res = Integer.MAX_VALUE;
        if (n < 5) {
        	return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves lzr = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
		int[] nums = { 9, 48, 92, 48, 81, 31 };
		int result = lzr.minDifference(nums);
		System.out.println(result);
	}
}