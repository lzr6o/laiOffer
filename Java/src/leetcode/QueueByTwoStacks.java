package leetcode;
import java.util.LinkedList;

class QueueByTwoStacks {
	LinkedList<Integer> in;
	LinkedList<Integer> out;
	
	QueueByTwoStacks() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	Integer poll() {
		move();
		return out.isEmpty() ? null : out.pollFirst();
	}
	
	void offer(int value) {
		in.offerFirst(value);
	}
	
	Integer peek() {
		move();
		return out.isEmpty() ? null : out.peekFirst();
	}
	
	void move() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}

	int size() {
		return in.size() + out.size();
	}
	
	boolean isEmpty() {
		return in.size() == 0 && out.size() == 0;
	}

	public static void main(String[] args) {
		QueueByTwoStacks lzr = new QueueByTwoStacks();
		lzr.offer(1);
		System.out.print(lzr.peek() + "\n");
		System.out.print(lzr.poll() + "\n");
		System.out.print(lzr.isEmpty() + "\n");
		System.out.print(lzr.size());
	}
}