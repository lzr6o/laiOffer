package leetcode;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	class TreeNode {
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

	TreeNode buildTree(int[] preorder, int[] inorder) {
		
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal lzr = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode tree = lzr.buildTree(preorder, inorder);
	}
}