package Code;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SuccessorLCCI {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		}
		TreeNode ans = inorderSuccessor(root.left, p);
		return ans == null ? root : ans;
	}

	TreeNode buildTree(Integer[] nodes) {
		TreeNode root = new TreeNode(nodes[0]);
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode cur = null;
		for (int i = 1; i < nodes.length; i++) {
			TreeNode node = nodes[i] != null ? new TreeNode(nodes[i]) : null;
			if (count == 0) {
				cur = queue.poll();
			}
			if (count == 0) {
				count++;
				cur.left = node;
			} else {
				count = 0;
				cur.right = node;
			}
			if (nodes[i] != null) {
				queue.offer(node);
			}
		}
		return root;
	}

	void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<String> curLayer = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur != null) {
					curLayer.add(Integer.toString(cur.val));
				} else {
					curLayer.add("#");
					continue;
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				} else {
					queue.offer(null);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				} else {
					queue.offer(null);
				}
			}
			for (String node : curLayer) {
				System.out.print(node + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		SuccessorLCCI lzr = new SuccessorLCCI();
		Integer[] nodes = { 5, 3, 6, 2, 4, null, null, 1 };
		TreeNode tree = lzr.buildTree(nodes);
		lzr.printTree(tree);
		System.out.print("\n");
		TreeNode p = tree.right;
		TreeNode res = lzr.inorderSuccessor(tree, p);
		System.out.print(res.val);
	}
}