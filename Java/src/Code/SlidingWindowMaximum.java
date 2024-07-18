package Code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SlidingWindowMaximum {
	
	int[] maxSlidingWindow(int[] nums, int k) {
		int r = 0, l = 0, idx = 0;
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		while (r < nums.length) {
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
				dq.pollLast();
			}
			dq.offerLast(r);
			if (l > dq.peekFirst()) {
				dq.pollFirst();
			}
			if (r + 1 >= k) {
				res[idx++] = nums[dq.peekFirst()];
				l++;
			}
			r++;
		}
		return res;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum lzr = new SlidingWindowMaximum();
		int[] nums = { 7, 2, 4 };
		int k = 2;
		int[] res = lzr.maxSlidingWindow(nums, k);
		System.out.print(Arrays.toString(res));
	}
}