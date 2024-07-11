package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
	List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int L = i + 1, R = nums.length - 1;
			while (L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if (sum > 0) {
					R--;
				} else if (sum < 0) {
					L++;
				} else {
					res.add(Arrays.asList(nums[i], nums[L], nums[R]));
					L++;
					while (L < R && nums[L] == nums[L - 1]) {
						L++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ThreeSum lzr = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = lzr.threeSum(nums);
		System.out.print(res);
	}
}