package Code;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SymmetricBinaryTree {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	boolean isSymmetric(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
	}
	
	TreeNode constructTree(int[] level) {
		TreeNode root = null;
		for (int i = 0; i < level.length; i++) {
			root = helper(root, level[i]);
		}
		return root;
	}
	
	TreeNode helper(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		
		if (value < root.key) {
			root.left = helper(root.left, value);
		} else {
			root.right = helper(root.right, value);
		}
		return root;
	}
	
	void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curLayer = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.key);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			System.out.print(curLayer + "\n");
		}
	}
	
	public static void main(String[] args) {
		SymmetricBinaryTree lzr = new SymmetricBinaryTree();
		int[] level = { 5, 3, 1, 4,  };
		TreeNode tree = lzr.constructTree(level);
		lzr.printTree(tree);
		boolean result = lzr.isSymmetric(tree);
		System.out.print(result);
	}
}