package Code;

class HouseRobberIII {

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

	int rob(TreeNode root) {
		return Math.max(dfs(root)[0], dfs(root)[1]);
	}

	int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		int[] leftPair = dfs(root.left);
		int[] rightPair = dfs(root.right);
		int withRoot = root.val + leftPair[1] + rightPair[1];
		int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);
		return new int[] { withRoot, withoutRoot };
	}

	public static void main(String[] args) {
		HouseRobberIII lzr = new HouseRobberIII();
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(1);
		int res = lzr.rob(tree);
		System.out.print(res);
	}
}