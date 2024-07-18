package Code;

import java.util.PriorityQueue;
import java.util.Queue;

class FindMedianFromDataStream {

	Queue<Integer> small, large;

	FindMedianFromDataStream() {
		small = new PriorityQueue<>((a, b) -> b - a);
		large = new PriorityQueue<>();
	}

	void addNum(int num) {
		large.add(num);
		small.add(large.poll());
		if (large.size() < small.size()) {
			large.add(small.poll());
		}
	}

	double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
	}

	public static void main(String[] args) {
		FindMedianFromDataStream lzr = new FindMedianFromDataStream();
		lzr.addNum(1);
		lzr.addNum(2);
		lzr.findMedian();
		lzr.addNum(3);
		lzr.findMedian();
	}
}