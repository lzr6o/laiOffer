package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindTheDifferenceOfTwoArrays {
	List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set2.add(num);
		}
		List<List<Integer>> dif = new ArrayList<>();
		dif.add(new ArrayList<>());
		dif.add(new ArrayList<>());
		for (int num : set1) {
			if (!set2.contains(num)) {
				dif.get(0).add(num);
			}
		}
		for (int num : set2) {
			if (!set1.contains(num)) {
				dif.get(1).add(num);
			}
		}
		return dif;
	}

	public static void main(String[] args) {
		FindTheDifferenceOfTwoArrays lzr = new FindTheDifferenceOfTwoArrays();
		int[] nums1 = { 1, 2, 3, 3 }, nums2 = { 1,1,2, 2};
		List<List<Integer>> res = lzr.findDifference(nums1, nums2);
		System.out.print(res);
	}
}