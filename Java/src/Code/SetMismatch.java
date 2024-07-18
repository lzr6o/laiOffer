package Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SetMismatch {
	
	int[] findErrorNums(int[] nums) {
		int dup = 0, miss = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i]))
				dup = nums[i];
			set.add(nums[i]);
		}
		for (int i = 1; i <= nums.length; ++i) {
			if (set.contains(i) == false) {
				miss = i;
				break;
			}
		}
		return new int[] { dup, miss };
	}

	public static void main(String[] args) {
		SetMismatch lzr = new SetMismatch();
		int[] nums = { 1, 2, 2, 4 };
		int[] res = lzr.findErrorNums(nums);
		System.out.print(Arrays.toString(res));
	}
}