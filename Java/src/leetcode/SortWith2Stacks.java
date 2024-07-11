package leetcode;
import java.util.Deque;
import java.util.LinkedList;

class SortWith2Stacks {
	void sort(LinkedList<Integer> s1) {
		if (s1 == null || s1.size() <= 1) {
			return;
		}
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		sort(s1, s2);
	}
	
	void sort(Deque<Integer> input, Deque<Integer> buffer) {
		int prevMax = Integer.MAX_VALUE;
		while (input.peekFirst() < prevMax) {
			int curMax = Integer.MIN_VALUE;
			int count = 0;
			while (!input.isEmpty() && input.peekFirst() < prevMax) {
				int cur = input.pollFirst();
				if (cur > curMax) {
					curMax = cur;
					count = 1;
				} else if (cur == curMax) {
					count++;
				}
				buffer.offerFirst(cur);
			}
			while (count-- > 0) {
				input.offerFirst(curMax);
			}
			while (!buffer.isEmpty()) {
				int tmp = buffer.pollFirst();
				if (tmp != curMax) {
					input.offerFirst(tmp);
				}
			}
			prevMax = curMax;
		}
	}
	
	LinkedList<Integer> constructLinkedList(int[] array) {
		LinkedList<Integer> dummy = new LinkedList<Integer>();
		for (int num : array) {
			dummy.offerFirst(num);
		}
		return dummy;
	}
	
	void printLinkedList(LinkedList<Integer> head) {
		while (!head.isEmpty()) {
			System.out.print(head.pollFirst() + " ");
		}
	}

	public static void main(String[] args) {
		SortWith2Stacks lzr = new SortWith2Stacks();
		int[] array = { 3, 2, 1 };
		LinkedList<Integer> s1 = lzr.constructLinkedList(array);
		lzr.sort(s1);
		lzr.printLinkedList(s1);
	}
}