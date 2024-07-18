package Code;
import java.util.ArrayList;
import java.util.List;

class PostOrderTraversalOfBinaryTreeRecursive {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	
	void helper(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		helper(root.left, res);
		helper(root.right, res);
		res.add(root.key);
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
	
	public static void main(String[] args) {
		PostOrderTraversalOfBinaryTreeRecursive lzr = new PostOrderTraversalOfBinaryTreeRecursive();
		int[] level = { 5, 3, 1, 4, 8, 11 };
		TreeNode tree = lzr.constructTree(level);
		List<Integer> result = lzr.postOrder(tree);
		System.out.print(result);
	}
}