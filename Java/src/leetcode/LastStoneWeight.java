package leetcode;

import java.util.PriorityQueue;

class LastStoneWeight {
	int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int stone : stones) {
			pq.offer(stone);
		}
		while (pq.size() > 1) {
			int one = pq.poll(), two = pq.poll();
			pq.offer(one - two);
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		LastStoneWeight lzr = new LastStoneWeight();
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		int res = lzr.lastStoneWeight(stones);
		System.out.print(res);
	}
}