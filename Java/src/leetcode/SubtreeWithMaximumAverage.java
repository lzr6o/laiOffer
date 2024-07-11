package leetcode;
class SubtreeWithMaximumAverage {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	TreeNode findSubtree2(TreeNode root) {
		TreeNode[] maxNode = new TreeNode[1];
		double[] max = new double[] { Double.NEGATIVE_INFINITY };
		helper(root, max, maxNode);
		return maxNode[0];
	}

	int[] helper(TreeNode root, double[] max, TreeNode[] maxNode) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		int sum = root.val;
		int nodes = 1;
		int[] left = helper(root.left, max, maxNode);
		int[] right = helper(root.right, max, maxNode);
		sum += left[0] + right[0];
		nodes += left[1] + right[1];
		double avg = (sum * 1.0) / nodes;
		if (avg > max[0]) {
			max[0] = avg;
			maxNode[0] = root;
		}
		return new int[] { sum, nodes };
	}

	public static void main(String[] args) {
		SubtreeWithMaximumAverage lzr = new SubtreeWithMaximumAverage();
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(-5);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(2);
		tree.right.left = new TreeNode(-4);
		tree.right.right = new TreeNode(-5);
		TreeNode res = lzr.findSubtree2(tree);
		System.out.print(res.val);
	}
}