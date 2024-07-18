package Code;
class MaximumPathSumBinaryTree {
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
		if (root.left == null && root.right == null) {
			return root.key;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		return root.left != null ? left + root.key : right + root.key;
	}
	
	public static void main(String[] args) {
		MaximumPathSumBinaryTree lzr = new MaximumPathSumBinaryTree();
		TreeNode tree = new TreeNode(-15);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int res = lzr.maxPathSum(tree);
		System.out.print(res);
	}
}