package leetcode;
class LowestCommonAncestorBinarySearchTree {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode lca(TreeNode root, int one, int two) {
		int small = Math.min(one, two);
		int large = Math.max(one, two);
		while (root != null) {
			if (root.key < small) {
				root = root.right;
			} else if (root.key > large) {
				root = root.left;
			} else {
				return root;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		LowestCommonAncestorBinarySearchTree lzr = new LowestCommonAncestorBinarySearchTree();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(12);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(14);
		TreeNode res = lzr.lca(tree, 1, 3);
		System.out.print(res.key);
	}
}