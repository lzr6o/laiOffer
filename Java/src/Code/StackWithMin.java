package Code;
import java.util.Deque;
import java.util.LinkedList;

class StackWithMin {
	Deque<Integer> stack;
	Deque<Integer> minStack;
	
	StackWithMin() {
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
	}

	int min() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peekFirst();
	}
	
	void push(int value) {
		stack.offerFirst(value);
		if (minStack.isEmpty() || value <= minStack.peekFirst()) {
			minStack.offerFirst(value);
		}
	}
	
	int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		Integer result = stack.pollFirst();
		if (minStack.peekFirst().equals(result)) {
			minStack.pollFirst();
		}
		return result;
	}

	int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}
	
	public static void main(String[] args) {
		StackWithMin lzr = new StackWithMin();
		lzr.push(1);
		lzr.push(2);
		lzr.pop();
		System.out.print(lzr.min() + "\n");
		lzr.pop();
		System.out.print(lzr.min());
	}
}