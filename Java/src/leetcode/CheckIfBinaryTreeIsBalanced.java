package leetcode;

class CheckIfBinaryTreeIsBalanced {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}

	int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = height(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	TreeNode constructTree(int[] level) {
		TreeNode root = null;
		for (int i = 0; i < level.length; i++) {
			root = helper(root, level[i]);
		}
		return root;
	}
	
	TreeNode helper(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		
		if (value < root.key) {
			root.left = helper(root.left, value);
		} else {
			root.right = helper(root.right, value);
		}
		return root;
	}
	
	public static void main(String[] args) {
		CheckIfBinaryTreeIsBalanced lzr = new CheckIfBinaryTreeIsBalanced();
		int[] level = { 5, 3, 1, 4, 8, 11 };
		TreeNode tree = lzr.constructTree(level);
		boolean result = lzr.isBalanced(tree);
		System.out.print(result);
	}
}