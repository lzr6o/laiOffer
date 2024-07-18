package Code;

class CountUnivalueSubtrees {

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

	int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] cnt = new int[1];
		dfs(root, cnt);
		return cnt[0];
	}

	boolean dfs(TreeNode root, int[] cnt) {
		if (root.left == null && root.right == null) {
			cnt[0]++;
			return true;
		}
		boolean tmp = true;
		if (root.left != null) {
			tmp = dfs(root.left, cnt) && root.val == root.left.val;
		}
		if (root.right != null) {
			tmp &= dfs(root.right, cnt) && root.val == root.right.val;
		}
		if (!tmp) {
			return false;
		}
		cnt[0]++;
		return true;
	}

	public static void main(String[] args) {
		CountUnivalueSubtrees lzr = new CountUnivalueSubtrees();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		int res = lzr.countUnivalSubtrees(root);
		System.out.print(res);
	}
}