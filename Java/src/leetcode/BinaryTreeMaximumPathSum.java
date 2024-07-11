package leetcode;

class BinaryTreeMaximumPathSum {

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

	int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		dfs(root, max);
		return max[0];
	}
	
	int dfs(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int L = dfs(root.left, max);
		int R = dfs(root.right, max);
		max[0] = Math.max(max[0], root.val + R + L);
		return root.val + Math.max(L, R) > 0 ? root.val + Math.max(L, R) : 0;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum lzr = new BinaryTreeMaximumPathSum();
		
	}
}
