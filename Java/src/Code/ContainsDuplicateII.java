package Code;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicateII {

	boolean containsNearbyDuplicate(int[] nums, int k) {
		int l = 0, r = 0;
		Set<Integer> set = new HashSet<>();
		while (r < nums.length) {
			if (r - l > k) {
				set.remove(nums[l]);
				l++;
			}
			if (set.contains(nums[r])) {
				return true;
			}
			set.add(nums[r]);
			r++;
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII lzr = new ContainsDuplicateII();
		int k = 2;
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		boolean res = lzr.containsNearbyDuplicate(nums, k);
		System.out.print(res);
	}
}