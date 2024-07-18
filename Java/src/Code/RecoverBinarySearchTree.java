package Code;
class RecoverBinarySearchTree {
	static class TreeNode {
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

	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	
    TreeNode recoverTree(TreeNode root) {
        dfs(root);
        swap(first, second);
        return root;
    }
    
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;
        dfs(root.right);
    }
	
	void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
	
	public static void main(String[] args) {
		RecoverBinarySearchTree lzr = new RecoverBinarySearchTree();
		TreeNode tree = new TreeNode(4);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(6);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(5);
		tree.right.left = new TreeNode(3);
		tree.right.right = new TreeNode(7);
		TreeNode newTree = lzr.recoverTree(tree);
		
	}
}