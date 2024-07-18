package Code;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MaximumValuesOfSizeKSlidingWindows {
	List<Integer> maxWindows(int[] array, int k) {
		List<Integer> max = new ArrayList<Integer>();
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				max.add(array[deque.peekFirst()]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumValuesOfSizeKSlidingWindows lzr = new MaximumValuesOfSizeKSlidingWindows();
		int[] array = { 1, 2, 3, 2, 4, 2, 1 };
		int k = 3;
		List<Integer> result = lzr.maxWindows(array, k);
		System.out.print(result);
	}
}