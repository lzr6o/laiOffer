package leetcode;
class MaxPathSumFromLeafToRoot {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	int maxPathSumLeafToRoot(TreeNode root) {
		return maxPathSum(root, 0);
	}
	
	int maxPathSum(TreeNode root, int sum) {
		sum += root.key;
		if (root.left == null && root.right == null) {
			return sum;
		} else if (root.left == null) {
			return maxPathSum(root.right, sum);
		} else if (root.right == null) {
			return maxPathSum(root.left, sum);
		}
		return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
	}

	public static void main(String[] args) {
		MaxPathSumFromLeafToRoot lzr = new MaxPathSumFromLeafToRoot();
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(-2);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(-4);
		int res = lzr.maxPathSumLeafToRoot(tree);
		System.out.print(res);
	}
}