package Code;

import java.util.Arrays;
import java.util.Stack;

class CarFleet {
	int carFleet(int target, int[] position, int[] speed) {
		int[][] arr = new int[position.length][2];
		for (int i = 0; i < position.length; i++) {
			arr[i][0] = position[i];
			arr[i][1] = speed[i];
		}
		Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
		Stack<Double> stack = new Stack<>();
		for (int[] a : arr) {
			double time = 1.0 * (target - a[0]) / a[1];
			System.out.println(time);
			while (!stack.empty() && time >= stack.peek()) {
				stack.pop();
			}
			stack.push(time);
		}
		return stack.size();
	}

	public static void main(String[] args) {
		CarFleet lzr = new CarFleet();
		int target = 10;
		int[] position = { 6, 8 };
		int[] speed = { 3, 2 };
		int res = lzr.carFleet(target, position, speed);
		System.out.print(res);
	}
}