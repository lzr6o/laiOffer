package leetcode;

import java.util.Stack;

class MakeTheStringGreat {
	String makeGood(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = stack.pop() + res;
		}
		return res;
	}

	public static void main(String[] args) {
		MakeTheStringGreat lzr = new MakeTheStringGreat();
		String s = "leEeetcode";
		String res = lzr.makeGood(s);
		System.out.print(res);
	}
}