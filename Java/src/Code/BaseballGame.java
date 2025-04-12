package Code;

import java.util.Stack;

class BaseballGame {
	int calPoints(String[] ops) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (String op : ops) {
			switch (op) {
				case "+":
					int a = stack.pop();
					int b = stack.peek();
					stack.push(a);
					stack.push(a + b);
					sum += a + b;
					break;
				case "D":
					int top = stack.peek();
					stack.push(top * 2);
					sum += top * 2;
					break;
				case "C":
					sum -= stack.pop();
					break;
				default:
					int c = Integer.parseInt(op);
					stack.push(c);
					sum += c;
					break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		BaseballGame lzr = new BaseballGame();
		String[] ops = { "5", "2", "C", "D", "+" };
		int res = lzr.calPoints(ops);
		System.out.print(res);
	}
}
