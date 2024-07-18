package Code;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {

	boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate lzr = new ContainsDuplicate();
		int[] nums = { 1, 2, 3, 1 };
		boolean res = lzr.containsDuplicate(nums);
		System.out.print(res);
	}
}