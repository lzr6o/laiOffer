package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SerializeAndDeserializeBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	String serialize(TreeNode root) {
		if (root == null) {
			return "N";
		}
		return root.val + "," + serialize(root.left) + "," + serialize(root.right);
	}

	TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
		return dfs(queue);
	}

	TreeNode dfs(Queue<String> queue) {
		String s = queue.poll();
		if (s.equals("N")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(s));
		root.left = dfs(queue);
		root.right = dfs(queue);
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
		SerializeAndDeserializeBinaryTree lzr = new SerializeAndDeserializeBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		String serialize = lzr.serialize(root);
		TreeNode tree = lzr.deserialize(serialize);
		lzr.printTree(tree);
	}
}