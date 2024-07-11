package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class DeleteNodesAndReturnForest {
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

	List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int node : to_delete) {
			set.add(node);
		}
		dfs(root, set, true, res);
		return res;
	}

	TreeNode dfs(TreeNode root, Set<Integer> set, boolean isRoot, List<TreeNode> res) {
		if (root == null) {
			return null;
		}
		boolean deleted = set.contains(root.val);
		if (isRoot && !deleted) {
			res.add(root);
		}
		root.left = dfs(root.left, set, deleted, res);
		root.right = dfs(root.right, set, deleted, res);
		return deleted ? null : root;
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
		DeleteNodesAndReturnForest lzr = new DeleteNodesAndReturnForest();
		Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = lzr.buildTree(nodes);
		int[] to_delete = { 3, 5 };
		List<TreeNode> res = lzr.delNodes(root, to_delete);
		lzr.printTree(root);
		for (TreeNode node : res) {
			System.out.print(node.val + " ");
		}
	}
}