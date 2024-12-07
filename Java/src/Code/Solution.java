package Code;

import java.util.Stack;

public class Solution {
	public boolean isStringValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character pairs : s.toCharArray()) {
			if (pairs == '（') {
				stack.push(')');
			} else if (pairs == '[') {
				stack.push(']');
			} else if (pairs == '{') {
				stack.push('}');
			}
			if ((pairs == ')') || (pairs == ']') || (pairs == '}')) {
				if (stack.isEmpty() || pairs != stack.pop()) {
					return false;
				}
				return stack.isEmpty();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution lzr = new Solution();
		String s = "()[]{}";
		boolean res = lzr.isStringValid(s);
		System.out.print(res);
	}
}