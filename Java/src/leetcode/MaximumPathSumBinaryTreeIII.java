package leetcode;
class MaximumPathSumBinaryTreeIII {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}

	int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		int sum = Math.max(Math.max(left, right), 0) + root.key;
		max[0] = Math.max(max[0], sum);
		return sum;
	}

	public static void main(String[] args) {
		MaximumPathSumBinaryTreeIII lzr = new MaximumPathSumBinaryTreeIII();
		TreeNode tree = new TreeNode(-5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		tree.right.right.left = new TreeNode(-3);
		int res = lzr.maxPathSum(tree);
		System.out.print(res);
	}
}