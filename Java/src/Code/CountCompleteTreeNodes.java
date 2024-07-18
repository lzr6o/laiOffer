package Code;

import java.util.LinkedList;
import java.util.Queue;

class CountCompleteTreeNodes {

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

	int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return countNodes(root.left) + 1 + countNodes(root.right);
		}
	}

	TreeNode buildTree(Integer[] nodes) {
		TreeNode root = new TreeNode(nodes[0]);
		int cnt = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode cur = null;
		for (int i = 1; i < nodes.length; i++) {
			TreeNode node = nodes[i] != null ? new TreeNode(nodes[i]) : null;
			if (cnt == 0) {
				cur = queue.poll();
			}
			if (cnt == 0) {
				cnt++;
				cur.left = node;
			} else {
				cnt = 0;
				cur.right = node;
			}
			if (nodes[i] != null) {
				queue.offer(node);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes lzr = new CountCompleteTreeNodes();
		Integer[] nodes = { 1, 2, 3, 4, 5, 6 };
		TreeNode root = lzr.buildTree(nodes);
		int res = lzr.countNodes(root);
		System.out.print(res);
	}
}
