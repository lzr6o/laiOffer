package Code;

class DiameterOfBinaryTree {

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

	int diameterOfBinaryTree(TreeNode root) {
		int[] max = new int[1];
		dfs(root, max);
		return max[0] - 1;
	}
	
	int dfs(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, max);
		int right = dfs(root.right, max);
		max[0] = Math.max(max[0], left + right + 1);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		DiameterOfBinaryTree lzr = new DiameterOfBinaryTree();

	}
}