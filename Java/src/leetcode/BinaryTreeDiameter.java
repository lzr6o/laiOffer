package leetcode;

class BinaryTreeDiameter {
	int diameter(TreeNode root) {
		int[] maxPath = new int[1];
		maxPath[0] = 0;
		dfs(root, maxPath);
		return maxPath[0];
	}

	int dfs(TreeNode root, int[] maxPath) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, maxPath);
		int right = dfs(root.right, maxPath);
		if (left != 0 && right != 0) {
			maxPath[0] = Math.max(maxPath[0], left + right + 1);
		}
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		BinaryTreeDiameter lzr = new BinaryTreeDiameter();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int result = lzr.diameter(tree);
		System.out.print(result);
	}
}