package Code;

import java.util.Stack;

class ValidParentheses {

	boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses lzr = new ValidParentheses();
		String s = ")]";
		boolean res = lzr.isValid(s);
		System.out.print(res);
	}
}