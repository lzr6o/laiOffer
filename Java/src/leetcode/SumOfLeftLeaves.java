package leetcode;

class SumOfLeftLeaves {

	int sum = 0;

    int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
		return sum;
	}

	void dfs(TreeNode root, boolean isLeft) {
		if (root == null) {
			return;
		}
		if (isLeft && root.left == null && root.right == null) {
			sum += root.val;
		}
		dfs(root.left, true);
		dfs(root.right, false);
	}
	
	public static void main(String[] args) {
		SumOfLeftLeaves lzr = new SumOfLeftLeaves();
		Integer[] nodes = {3, 9, 20, null, null, 15, 7};
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		int res = lzr.sumOfLeftLeaves(root);
		System.out.print(res);
	}
}