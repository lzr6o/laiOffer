package leetcode;
class SearchInBinarySearchTree {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode search(TreeNode root, int key) {
		if (root == null || root.key == key) {
			return root;
		}
		return search(key < root.key ? root.left : root.right, key);
	}
	
	public static void main(String args[]) {
		SearchInBinarySearchTree lzr = new SearchInBinarySearchTree();
		TreeNode tree = new TreeNode(6);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(4);
		TreeNode node = lzr.search(tree, 8);
		System.out.print(node.key);
	}
}