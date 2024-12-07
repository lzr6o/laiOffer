package Code;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class KthSmallestWithOnly357AsFactors {
	long kth(int k) {
		PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
		Set<Long> visited = new HashSet<>();
		minHeap.offer(3 * 5 * 7L);
		visited.add(3 * 5 * 7L);
		while (k > 1) {
			long cur = minHeap.poll();
			if (visited.add(3 * cur)) {
				minHeap.offer(3 * cur);
			}
			if (visited.add(5 * cur)) {
				minHeap.offer(5 * cur);
			}
			if (visited.add(7 * cur)) {
				minHeap.offer(7 * cur);
			}
			k--;
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		KthSmallestWithOnly357AsFactors lzr = new KthSmallestWithOnly357AsFactors();
		int k = 1;
		long res = lzr.kth(k);
		System.out.print(res);
	}
}