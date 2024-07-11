package leetcode;
class LargestNumberSmallerInBinarySearchTree {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	int largestSmaller(TreeNode root, int target) {
		int result = Integer.MIN_VALUE;
		while (root != null) {
			if (root.key >= target) {
				root = root.left;
			} else {
				result = root.key;
				root = root.right;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LargestNumberSmallerInBinarySearchTree lzr = new LargestNumberSmallerInBinarySearchTree();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int result = lzr.largestSmaller(tree, 10);
		System.out.print(result);
	}
}