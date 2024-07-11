package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class EvaluateReversePolishNotation {

	int evalRPN(String[] tokens) {
		int res = 0;
		Deque<Integer> stack = new LinkedList<Integer>();
		for (String s : tokens) {
			if (isNumeric(s)) {
				int num = Integer.parseInt(s);
				stack.offerLast(num);
			} else {
				int a = stack.pollLast();
				int b = stack.pollLast();
				switch (s) {
					case "+":
						res = b + a;
						stack.offerLast(res);
						break;
					case "-":
						res = b - a;
						stack.offerLast(res);
						break;
					case "*":
						res = b * a;
						stack.offerLast(res);
						break;
					case "/":
						res = b / a;
						stack.offerLast(res);
						break;
				}
			}
		}
		return res;
	}

	boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation lzr = new EvaluateReversePolishNotation();
		String[] tokens = { "2", "1", "+", "3", "*" };
		int result = lzr.evalRPN(tokens);
		System.out.print(result);
	}
}