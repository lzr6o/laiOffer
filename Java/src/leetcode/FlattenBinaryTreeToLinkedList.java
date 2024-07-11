package leetcode;

class FlattenBinaryTreeToLinkedList {
	
	TreeNode pre;

	void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = pre;
		root.left = null;
		pre = root;
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList lzr = new FlattenBinaryTreeToLinkedList();
		Integer[] nodes = { 1, 2, 5, 3, 4, null, 6 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		lzr.flatten(root);
		TreeNode.print(root);
	}
}