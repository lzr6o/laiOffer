package Code;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HandOfStraights {
	boolean isNStraightHand(int[] hand, int groupSize) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		for (int num : hand) {
			if (!map.containsKey(num)) {
				pq.add(num);
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		while (!pq.isEmpty()) {
			int cur = pq.peek();
			for (int i = 0; i < groupSize; i++) {
				if (!map.containsKey(cur + i)) {
					return false;
				}
				map.put(cur + i, map.get(cur + i) - 1);
				if (map.get(cur) != 0 && map.get(cur + i) == 0) {
					return false;
				}
			}
			while (!pq.isEmpty() && map.get(pq.peek()) == 0) {
				pq.poll();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		HandOfStraights lzr = new HandOfStraights();
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int groupSize = 3;
		boolean res = lzr.isNStraightHand(hand, groupSize);
		System.out.print(res);
	}
}