package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SortAnArray {
	int[] sortArray(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		bubbleSort(nums);
		for (int i : nums)
			res.add(i);
		return res;
	}

	void bubbleSort(int[] nums) {
		for (int k = nums.length - 1; k >= 1; k--) {
			for (int i = 0; i < k; i++) {
				if (nums[i] > nums[i + 1])
					swap(nums, i, i + 1);
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public static void main(String[] args) {
		SortAnArray lzr = new SortAnArray();
		int[] nums = { 5, 2, 3, 1 };
		int[] res = lzr.sortArray(nums);
		System.out.print(Arrays.toString(res));
	}
}