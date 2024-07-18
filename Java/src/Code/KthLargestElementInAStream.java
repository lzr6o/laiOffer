package Code;
import java.util.PriorityQueue;

class KthLargestElementInAStream {

	PriorityQueue<Integer> pq;
	int qSize;

	KthLargestElementInAStream(int k, int[] nums) {
		pq = new PriorityQueue<>(k);
		qSize = k;
		for (int num : nums) {
			add(num);
		}
	}

	int add(int val) {
		if (pq.size() < qSize) {
			pq.add(val);
		} else if (pq.peek() < val) {
			pq.poll();
			pq.add(val);
		}
		return pq.peek();
	}

	public static void main(String[] args) {

	}
}