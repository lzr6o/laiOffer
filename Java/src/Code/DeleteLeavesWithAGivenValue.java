package Code;

class DeleteLeavesWithAGivenValue {
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
		Integer[] nodes = {1, 2, null, 2};
		TreeNode root = TreeNode.build(nodes);
		System.out.print("Before :" + "\n");
		TreeNode.print(root);
		TreeNode res = lzr.removeLeafNodes(root, 2);
		System.out.print("After :" + "\n");
		TreeNode.print(res);
	}
}