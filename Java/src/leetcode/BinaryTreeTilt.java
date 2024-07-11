package leetcode;

class BinaryTreeTilt {
	
	int sum = 0;
	
	int findTilt(TreeNode root) {
		dfs(root);
		return sum;
	}

	int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		sum += Math.abs(left - right);
		return left + right + root.val;
	}
	
	public static void main(String[] args) {
		BinaryTreeTilt lzr = new BinaryTreeTilt();
		Integer[] nodes = { 1, 2, 3 };
		TreeNode root = TreeNode.build(nodes);
		int res = lzr.findTilt(root);
		System.out.print(res);
	}
}