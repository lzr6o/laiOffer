package leetcode;

class BinaryTreeDiameter {

	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	int diameter(TreeNode root) {
		int[] maxPath = new int[1];
		maxPath[0] = 0;
		helper(root, maxPath);
		return maxPath[0];
	}

	int helper(TreeNode root, int[] maxPath) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, maxPath);
		int right = helper(root.right, maxPath);
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