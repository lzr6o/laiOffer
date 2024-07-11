package leetcode;
import java.util.ArrayList;
import java.util.List;

class DifferentWaysToAddParentheses {
	List<Integer> diffWaysToCompute(String expression) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
				for (int l : left) {
					for (int r : right) {
						int res = 0;
						switch (c) {
						case '+':
							res = l + r;
							break;
						case '-':
							res = l - r;
							break;
						case '*':
							res = l * r;
							break;
						}
						ans.add(res);
					}
				}
			}
		}
		if (ans.isEmpty()) {
			ans.add(Integer.valueOf(expression));
		}
		return ans;
	}

	public static void main(String[] args) {
		DifferentWaysToAddParentheses lzr = new DifferentWaysToAddParentheses();
		String expression = "2*3-4*5";
		List<Integer> res = lzr.diffWaysToCompute(expression);
		System.out.print(res);
	}
}