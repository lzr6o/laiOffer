package Code;

class DeleteInBinarySearchTree {
	TreeNode findSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while (cur.left != null) {
			prev = cur;
			cur = cur.left;
		}
		prev.left = prev.left.right;
		return cur;
	}

	TreeNode deleteTree(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteTree(root.left, key);
			return root;
		} else if (root.val < key) {
			root.right = deleteTree(root.right, key);
			return root;
		}
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}
		TreeNode smallest = findSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}

	public static void main(String args[]) {
		
	}
}