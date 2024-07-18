package Code;

import java.util.LinkedList;
import java.util.Queue;

class CheckIfBinaryTreeIsCompleted {
	boolean isCompleted(TreeNode root) {
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
		CheckIfBinaryTreeIsCompleted lzr = new CheckIfBinaryTreeIsCompleted();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(4);
		boolean res = lzr.isCompleted(tree);
		System.out.print(res);
	}
}