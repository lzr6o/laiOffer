package Code;
import java.util.ArrayDeque;
import java.util.Deque;

class DequeByThreeStacks {
	private Deque<Integer> left;
	private Deque<Integer> right;
	private Deque<Integer> buffer;
	
	DequeByThreeStacks() {
		left = new ArrayDeque<>();
		right = new ArrayDeque<>();
		buffer = new ArrayDeque<>();
	}

	void offerFirst(int element) {
		left.offerFirst(element);
	}

	void offerLast(int element) {
		right.offerFirst(element);
	}

	Integer pollFirst() {
		move(right, left);
		return left.isEmpty() ? null : left.pollFirst();
	}

	Integer pollLast() {
		move(left, right);
		return right.isEmpty() ? null : right.pollFirst();
	}

	Integer peekFirst() {
		move(right, left);
		return left.isEmpty() ? null : left.peekFirst();
	}

	Integer peekLast() {
		move(left, right);
		return right.isEmpty() ? null : right.peekFirst();
	}

	int size() {
		return left.size() + right.size();
	}

	boolean isEmpty() {
		return left.isEmpty() && right.isEmpty();
	}

	void move(Deque<Integer> src, Deque<Integer> dest) {
		if (!dest.isEmpty()) {
			return;
		}
		int halfSize = src.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			buffer.offerFirst(src.pollFirst());
		}
		while (!src.isEmpty()) {
			dest.offerFirst(src.pollFirst());
		}
		while (!buffer.isEmpty()) {
			src.offerFirst(buffer.pollFirst());
		}
	}

	public static void main(String[] args) {
		DequeByThreeStacks lzr = new DequeByThreeStacks();
		lzr.offerFirst(1);
		lzr.offerLast(2);
		System.out.print(lzr.peekFirst() + "\n");
		System.out.print(lzr.peekLast() + "\n");
		System.out.print(lzr.pollFirst() + "\n");
		System.out.print(lzr.pollLast() + "\n");
		System.out.print(lzr.size() + "\n");
		System.out.print(lzr.isEmpty());
	}
}