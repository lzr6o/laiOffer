package leetcode;

class CountGoodNodesInBinaryTree {

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

	int goodNodes(TreeNode root) {
		int[] res = new int[1];
		int max = root.val;
		dfs(root, max, res);
		return res[0];
	}

	void dfs(TreeNode root, int max, int[] res) {
		if (root == null) {
			return;
		}
		if (root.val >= max) {
			res[0]++;
		}
		max = Math.max(max, root.val);
		dfs(root.left, max, res);
		dfs(root.right, max, res);
	}
	
	public static void main(String[] args) {
		CountGoodNodesInBinaryTree lzr = new CountGoodNodesInBinaryTree();
		
	}
}