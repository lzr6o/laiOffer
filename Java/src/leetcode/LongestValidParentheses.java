package leetcode;

import java.util.Stack;

class LongestValidParentheses {
	int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestValidParentheses lzr = new LongestValidParentheses();
		String s = "())()";
		int res = lzr.longestValidParentheses(s);
		System.out.print(res);
	}
}