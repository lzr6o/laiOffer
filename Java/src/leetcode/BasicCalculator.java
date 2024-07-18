package leetcode;

import java.util.Stack;

class BasicCalculator {
	int calculate(String s) {
		Stack<Character> op = new Stack<>();
		Stack<Integer> num = new Stack<>();
		StringBuilder sb = new StringBuilder();

	}

	public static void main(String[] args) {
		BasicCalculator lzr = new BasicCalculator();
		String s = "2 - 1 + 2";
		int res = lzr.calculate(s);
		System.out.print(res);
	}
}