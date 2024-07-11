package leetcode;
import java.util.Arrays;

class PartitionToKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) {
			return false;
		}
		int sum = 0, left = 0, right = nums.length - 1;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		int[] bucket = new int[k];
		int target = sum / k;
		Arrays.sort(nums);
		while (left <= right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		return backtrack(nums, 0, bucket, target);
	}

	boolean backtrack(int[] nums, int index, int[] bucket, int target) {
		if (index == nums.length) {
			for (int i = 0; i < bucket.length; i++) {
				if (bucket[i] != target) {
					return false;
				}
			}
			return true;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] + nums[index] > target) {
				continue;
			}
			bucket[i] += nums[index];
			System.out.println(Arrays.toString(bucket));
			if (backtrack(nums, index + 1, bucket, target)) {
				return true;
			}
			bucket[i] -= nums[index];
			if (bucket[i] == 0) {
				break;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PartitionToKEqualSumSubsets lzr = new PartitionToKEqualSumSubsets();
		int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
		int k = 4;
		boolean res = lzr.canPartitionKSubsets(nums, k);
		System.out.print(res);
	}
}