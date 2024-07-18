package Code;

class HeightOfBinaryTree {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}

	int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
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
		HeightOfBinaryTree lzr = new HeightOfBinaryTree();
		int[] level = { 5, 3, 1, 4, 8, 11 };
		TreeNode tree = lzr.constructTree(level);
		int result = lzr.findHeight(tree);
		System.out.print(result);
	}
}