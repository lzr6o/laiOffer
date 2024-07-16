package leetcode;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
	int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int res = 0;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int len = 0;
				while (set.contains(num + len)) {
					len++;
				}
				res = Math.max(res, len);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence lzr = new LongestConsecutiveSequence();
		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		int res = lzr.longestConsecutive(nums);
		System.out.print(res);
	}
}