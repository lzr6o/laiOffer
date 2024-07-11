package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class GetKeysInBinaryTreeFromRightView {
	List<Integer> layerByLayer(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerLast(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			res.add(deque.peekLast().val);
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.pollFirst();
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		GetKeysInBinaryTreeFromRightView lzr = new GetKeysInBinaryTreeFromRightView();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(4);
		tree.right.right = new TreeNode(11);
		List<Integer> res = lzr.layerByLayer(tree);
		System.out.print(res);
	}
}
