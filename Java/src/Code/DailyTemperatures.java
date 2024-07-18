package Code;

import java.util.Arrays;
import java.util.Stack;

class DailyTemperatures {

	int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (temperatures[i] < temperatures[stack.peek()]) {
				res[i] = stack.peek() - i;
				stack.push(i);
			} else {
				while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
					stack.pop();
				}
				res[i] = !stack.isEmpty() ? stack.peek() - i : 0;
				stack.push(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		DailyTemperatures lzr = new DailyTemperatures();
		int[] temperatures = { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 };
		int[] res = lzr.dailyTemperatures(temperatures);
		System.out.print(Arrays.toString(res));
	}
}