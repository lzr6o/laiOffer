package Code;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePostorderTraversal {
	List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}

	void postOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}

	public static void main(String[] args) {
		BinaryTreePostorderTraversal lzr = new BinaryTreePostorderTraversal();
		Integer[] nodes = { 1, null, 2, 3 };
		TreeNode root = TreeNode.build(nodes);
		List<Integer> res = lzr.postorderTraversal(root);
		System.out.print(res);
	}
}