package leetcode;

class CousinsInBinaryTree {

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

	boolean isCousins(TreeNode root, int x, int y) {
		TreeNode[] xPar = new TreeNode[1];
		int[] xDep = new int[1];
		TreeNode[] yPar = new TreeNode[1];
		int[] yDep = new int[1];
		dfs(root, x, y, xPar, xDep, yPar, yDep, 0, null);
		return xPar[0] != yPar[0] && xDep[0] == yDep[0];
	}

	void dfs(TreeNode root, int x, int y, TreeNode[] xPar, int[] xDep, TreeNode[] yPar, int[] yDep, int dep, TreeNode par) {
		if (root == null) {
			return;
		}
		if (root.val == x) {
			xPar[0] = par;
			xDep[0] = dep;
		}
		if (root.val == y) {
			yPar[0] = par;
			yDep[0] = dep;
		}
		dfs(root.left, x, y, xPar, xDep, yPar, yDep, dep + 1, root);
		dfs(root.right, x, y, xPar, xDep, yPar, yDep, dep + 1, root);
	}
	
	public static void main(String[] args) {
		CousinsInBinaryTree lzr = new CousinsInBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		boolean res = lzr.isCousins(root, 2, 3);
		System.out.print(res);
	}
}