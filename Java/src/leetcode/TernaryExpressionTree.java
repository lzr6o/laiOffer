package leetcode;
class TernaryExpressionTree {

	class ExpNode {
		char symbol;
		ExpNode left;
		ExpNode right;

		ExpNode(char symbol) {
			this.symbol = symbol;
		}
	}

	ExpNode tree(String exp) {
		if (exp == null || exp.length() == 0) {
			return null;
		}
		int[] idx = new int[1];
		return dfs(exp, idx);
	}

	ExpNode dfs(String exp, int[] idx) {
		ExpNode root = new ExpNode(exp.charAt(idx[0]));
		idx[0] += 2;
		if (idx[0] - 1 < exp.length() && exp.charAt(idx[0] - 1) == '?') {
			root.left = dfs(exp, idx);
			root.right = dfs(exp, idx);
		}
		return root;
	}

	public static void main(String[] args) {
		TernaryExpressionTree lzr = new TernaryExpressionTree();
		String exp = "a?b?c:d:e";
		ExpNode tree = lzr.tree(exp);
		System.out.println(tree.symbol);
		System.out.println(tree.left.symbol);
		System.out.println(tree.right.symbol);
		System.out.println(tree.left.left.symbol);
	}
}