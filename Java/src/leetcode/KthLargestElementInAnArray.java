package leetcode;

import java.util.PriorityQueue;

class KthLargestElementInAnArray {

	int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		for (int num : nums) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		KthLargestElementInAnArray lzr = new KthLargestElementInAnArray();
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		int res = lzr.findKthLargest(nums, k);
		System.out.print(res);
	}
}