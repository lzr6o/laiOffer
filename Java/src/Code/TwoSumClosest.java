package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TwoSumClosest {
	List<Integer> closest(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int first, second;
		first = second = 0;
		List<Integer> closest = new ArrayList<Integer>();
		int diff = Integer.MAX_VALUE;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (Math.abs(sum - target) < diff) {
				diff = Math.abs(sum - target);
				first = nums[left];
				second = nums[right];
			}
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				break;
			}
		}
		closest.add(first);
		closest.add(second);
		return closest;
	}

	public static void main(String[] args) {
		TwoSumClosest lzr = new TwoSumClosest();
		int[] array = { 1, 4, 7, 13 };
		int target = 7;
		List<Integer> result = lzr.closest(array, target);
		System.out.print(result);
	}
}