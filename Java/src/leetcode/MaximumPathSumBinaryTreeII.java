package leetcode;
class MaximumPathSumBinaryTreeII {
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
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(max[0], root.key + left + right);
		return root.key + Math.max(left, right);
	}
	
	public static void main(String[] args) {
		MaximumPathSumBinaryTreeII lzr = new MaximumPathSumBinaryTreeII();
		TreeNode tree = new TreeNode(-1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(-14);
		int res = lzr.maxPathSum(tree);
		System.out.print(res);
	}
}