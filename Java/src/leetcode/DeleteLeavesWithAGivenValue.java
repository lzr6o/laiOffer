package leetcode;
class DeleteLeavesWithAGivenValue {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		return root.val == target && (root.left == null && root.right == null) ? null : root;
	}

	public static void main(String[] args) {
		DeleteLeavesWithAGivenValue lzr = new DeleteLeavesWithAGivenValue();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
		TreeNode res = lzr.removeLeafNodes(root, 2);
		
	}
}