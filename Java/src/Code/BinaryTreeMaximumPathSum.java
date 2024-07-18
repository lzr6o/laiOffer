package Code;

class BinaryTreeMaximumPathSum {
	int max;

	int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		dfs(root, max);
		return max;
	}

	int dfs(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		int L = dfs(root.left, max);
		int R = dfs(root.right, max);
		max = Math.max(max, root.val + R + L);
		return root.val + Math.max(L, R) > 0 ? root.val + Math.max(L, R) : 0;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum lzr = new BinaryTreeMaximumPathSum();

	}
}