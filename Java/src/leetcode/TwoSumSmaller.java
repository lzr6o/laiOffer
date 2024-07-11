package leetcode;
import java.util.Arrays;

class TwoSumSmaller {
	int smallerPairs(int[] nums, int target) {
		Arrays.sort(nums);
		int pairs = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum < target) {
				pairs += right - left;
				left++;
			} else {
				right--;
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		TwoSumSmaller lzr = new TwoSumSmaller();
		int[] nums = { 3, 4, 0, -1, 2, 0, 5 };
		int target = 4;
		int result = lzr.smallerPairs(nums, target);
		System.out.print(result);
	}
}