package leetcode;

class CheckIfBinaryTreeIsBalanced {
	boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return getHei(root) != -1;
	}

	int getHei(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lHei = getHei(root.left);
		if (lHei == -1) {
			return -1;
		}
		int rHei = getHei(root.right);
		if (rHei == -1) {
			return -1;
		}
		if (Math.abs(lHei - rHei) > 1) {
			return -1;
		}
		return Math.max(lHei, rHei) + 1;
	}

	public static void main(String[] args) {
		CheckIfBinaryTreeIsBalanced lzr = new CheckIfBinaryTreeIsBalanced();
		Integer[] nodes = { 5, 3, 1, 4, 8, 11 };
		TreeNode tree = TreeNode.build(nodes);
		System.out.print("Before :" + "\n");
		TreeNode.print(tree);
		boolean res = lzr.isBalanced(tree);
		System.out.print(res);
	}
}