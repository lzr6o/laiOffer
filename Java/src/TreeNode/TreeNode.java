package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode build(Integer[] nodes) {
		TreeNode root = new TreeNode(nodes[0]);
		int cnt = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		TreeNode cur = null;
		for (int i = 1; i < nodes.length; i++) {
			TreeNode node = nodes[i] != null ? new TreeNode(nodes[i]) : null;
			if (cnt == 0) {
				cur = q.poll();
			}
			if (cnt == 0) {
				cnt++;
				cur.left = node;
			} else {
				cnt = 0;
				cur.right = node;
			}
			if (nodes[i] != null) {
				q.offer(node);
			}
		}
		return root;
	}

	public static int getHei(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHei(root.left), getHei(root.right)) + 1;
	}

	public static int getCol(int hei) {
		if (hei == 1) {
			return 1;
		}
		return getCol(hei - 1) + getCol(hei - 1) + 1;
	}

	public static void treeToGraph(int[][] graph, TreeNode root, int col, int row, int hei) {
		if (root == null) {
			return;
		}
		graph[row][col] = root.val;
		treeToGraph(graph, root.left, col - (int) Math.pow(2, hei - 2), row + 1, hei - 1);
		treeToGraph(graph, root.right, col + (int) Math.pow(2, hei - 2), row + 1, hei - 1);
	}

	public static void print(TreeNode root) {
		int hei = getHei(root);
		int col = getCol(hei);
		int[][] graph = new int[hei][col];
		treeToGraph(graph, root, col / 2, 0, hei);
		for (int i = 0; i < hei; i++) {
			for (int j = 0; j < col; j++) {
				if (graph[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		Integer[] nodes = { 1, 2, 3, 4, null, 6, 7 };
		TreeNode tree = build(nodes);
		print(tree);
	}
}