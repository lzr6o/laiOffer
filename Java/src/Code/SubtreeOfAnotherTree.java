package Code;
class SubtreeOfAnotherTree {
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

	boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (dfs(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	boolean dfs(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null || one.val != two.val) {
			return false;
		}
		return dfs(one.left, two.left) && dfs(one.right, two.right);
	}

	public static void main(String[] args) {
		SubtreeOfAnotherTree lzr = new SubtreeOfAnotherTree();

	}
}