package Code;

import java.util.Stack;

class RemoveAllAdjacentDuplicatesInStringII {
	class Pair {
		Character c;
		Integer cnt;

		Pair(Character c, Integer cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}

	String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (stack.isEmpty() || stack.peek().c != c) {
				stack.push(new Pair(c, 1));
			} else {
				stack.peek().cnt++;
			}
			if (stack.peek().cnt == k) {
				stack.pop();
			}
		}
		String res = "";
		while (!stack.isEmpty()) {
			for (int i = 0; i < stack.peek().cnt; i++) {
				res = stack.peek().c + res;
			}
			stack.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInStringII lzr = new RemoveAllAdjacentDuplicatesInStringII();
		String s = "deeedbbcccbdaa";
		int k = 3;
		String res = lzr.removeDuplicates(s, k);
		System.out.print(res);
	}
}