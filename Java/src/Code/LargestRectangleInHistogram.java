package Code;
import java.util.Deque;
import java.util.LinkedList;

class LargestRectangleInHistogram {
	int largest(int[] array) {
		int result = 0;
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i <= array.length; i++) {
			int cur = i == array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		LargestRectangleInHistogram lzr = new LargestRectangleInHistogram();
		int[] array = { 2, 1, 3, 4, 5, 2, 6 };
		int result = lzr.largest(array);
		System.out.print(result);
	}
}