package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class StackByQueues {
	Queue<Integer> q1;
	Queue<Integer> q2;	

	StackByQueues() {
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
	}

	void push(int x) {
		q1.offer(x);
	}
	
	Integer pop() {
		Integer prev = q1.poll();
		Integer cur = q1.poll();
		while (cur != null) {
			q2.offer(prev);
			prev = cur;
			cur = q1.poll();
		}
		Queue<Integer> tmp = q1;
		q1 = q2;
		q2 = tmp;
		return prev;
	}

	Integer top() {
		Integer ret = pop();
		if (ret != null) {
			q1.offer(ret);
		}
		return ret;
	}
	
	boolean isEmpty() {
		return top() == null;
	}

	public static void main(String[] args) {
		StackByQueues lzr = new StackByQueues();
		lzr.push(1);
		System.out.print(lzr.top() + "\n");
		System.out.print(lzr.pop() + "\n");
		System.out.print(lzr.isEmpty());
	}
}