package leetcode;

import java.util.Stack;

class DecodeString {

	String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray();
		for (char c : arr) {
			if (c != ']') {
				stack.push(c);
			} else {
				while (stack.peek() != '[') {
					sb.append(stack.pop());
				}
				stack.pop();
				String tmp = sb.toString();
				sb = new StringBuilder();
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					sb.append(stack.pop());
				}
				int n = Integer.parseInt(sb.reverse().toString());				
				sb = new StringBuilder();
				for (int i = 0; i < n; i++) {
					sb.append(tmp);
				}
				for (int j = sb.length() - 1; j >= 0; j--) {
					stack.push(sb.charAt(j));
				}
				sb = new StringBuilder();
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		DecodeString lzr = new DecodeString();
		String s = "10[lzr]";
		String res = lzr.decodeString(s);
		System.out.print(res);
	}
}