package Code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
	List<Integer> zigZag(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		List<Integer> res = new ArrayList<>();
		deque.offerFirst(root);
		int layer = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				if (layer == 0) {
					TreeNode tmp = deque.pollLast();
					res.add(tmp.val);
					if (tmp.right != null) {
						deque.offerFirst(tmp.right);
					}
					if (tmp.left != null) {
						deque.offerFirst(tmp.left);
					}
				} else {
					TreeNode tmp = deque.pollFirst();
					res.add(tmp.val);
					if (tmp.left != null) {
						deque.offerLast(tmp.left);
					}
					if (tmp.right != null) {
						deque.offerLast(tmp.right);
					}
				}
			}
			layer = 1 - layer;
		}
		return res;
	}

	public static void main(String[] args) {
		GetKeysInBinaryTreeLayerByLayerZigZagOrder lzr = new GetKeysInBinaryTreeLayerByLayerZigZagOrder();
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(7);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(5);
		tree.right.right = new TreeNode(4);
		List<Integer> result = lzr.zigZag(tree);
		System.out.print(result);
	}
}