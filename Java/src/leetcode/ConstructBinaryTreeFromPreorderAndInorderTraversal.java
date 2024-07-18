package leetcode;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	TreeNode buildTree(int[] preorder, int[] inorder) {

	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal lzr = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode tree = lzr.buildTree(preorder, inorder);
	}
}