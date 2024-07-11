package leetcode;
class KthSmallestElementInABST {
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

	int kthSmallest(TreeNode root, int k) {
		int[] cnt = new int[1];
		cnt[0] = k;
		int[] res = new int[1];
		dfs(root, cnt, res);
		return res[0];
	}

	void dfs(TreeNode root, int[] cnt, int[] res) {
		if (root == null) {
			return;
		}
		dfs(root.left, cnt, res);
		cnt[0]--;
		if (cnt[0] == 0) {
			res[0] = root.val;
			return;
		}
		dfs(root.right, cnt, res);
	}
	
	public static void main(String[] args) {

	}
}