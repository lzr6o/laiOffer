package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class CheckCompletenessOfABinaryTree {
	boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur.left == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offer(cur.left);
			}
			if (cur.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckCompletenessOfABinaryTree lzr = new CheckCompletenessOfABinaryTree();

	}
}