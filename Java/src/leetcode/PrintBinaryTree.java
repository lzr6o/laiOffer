package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PrintBinaryTree {
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

	List<List<String>> res = new ArrayList<>();

	List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		int cols = (int) Math.pow(2, height) - 1;
		for (int i = 0; i < height; i++) {
			List<String> cur = new ArrayList<>();
			for (int j = 0; j < cols; j++) {
				cur.add("");
			}
			res.add(cur);
		}
		dfs(height, 0, cols, 0, root, res);
		return res;
	}

	void dfs(int height, int left, int right, int row, TreeNode root, List<List<String>> res) {
		if (root == null) {
			return;
		}
		if (row == height) {
			return;
		}
		int mid = (left + right) / 2;
		res.get(row).set(mid, Integer.toString(root.val));
		dfs(height + 1, left, mid - 1, row + 1, root.left, res);
		dfs(height + 1, mid + 1, right, row + 1, root.right, res);
	}

	int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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

	public static void main(String[] args) {
		PrintBinaryTree lzr = new PrintBinaryTree();
		Integer[] nodes = { 1, 2, 3, null, 4 };
		TreeNode tree = lzr.buildTree(nodes);
		List<List<String>> res = lzr.printTree(tree);
		System.out.print(res);
	}
}