package leetcode;
import java.util.LinkedList;
import java.util.Queue;

class MinimumDepthOfBinaryTree {
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

	int minDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int res = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur.left == null && cur.right == null) {
					return res;
				}
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree lzr = new MinimumDepthOfBinaryTree();
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		int res = lzr.minDepth(tree);
		System.out.print(res);
	}
}