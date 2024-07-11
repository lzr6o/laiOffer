package leetcode;

import java.util.Arrays;
import java.util.Stack;

class AsteroidCollision {
	int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
				int diff = asteroid + stack.peek();
				if (diff < 0) {
					stack.pop();
				} else if (diff > 0) {
					asteroid = 0;
				} else {
					asteroid = 0;
					stack.pop();
				}
			}
			if (asteroid != 0) {
				stack.push(asteroid);
			}
		}
		int[] res = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		AsteroidCollision lzr = new AsteroidCollision();
		int[] asteroids = { 10, 2, -5 };
		int[] res = lzr.asteroidCollision(asteroids);
		System.out.print(Arrays.toString(res));
	}
} 