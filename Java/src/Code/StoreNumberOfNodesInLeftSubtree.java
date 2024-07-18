package Code;
class StoreNumberOfNodesInLeftSubtree {
	static class TreeNodeLeft {
		int key;
		TreeNodeLeft left;
		TreeNodeLeft right;
		int numNodesLeft;
		TreeNodeLeft(int key) {
			this.key = key;
		}
	}
	
	void numNodesLeft(TreeNodeLeft root) {
		numNodes(root);
	}
	
	int numNodes(TreeNodeLeft root) {
		if (root == null) {
			return 0;
		}
		int leftNum = numNodes(root.left);
		int rightNum = numNodes(root.right);
		root.numNodesLeft = leftNum;
		return leftNum + rightNum + 1;
	}
	
	public static void main(String[] args) {
		StoreNumberOfNodesInLeftSubtree lzr = new StoreNumberOfNodesInLeftSubtree();
		TreeNodeLeft tree = new TreeNodeLeft(1);
		tree.left = new TreeNodeLeft(2);
		tree.right = new TreeNodeLeft(3);
		tree.left.left = new TreeNodeLeft(4);
		tree.left.right = new TreeNodeLeft(5);
		tree.left.left.left = new TreeNodeLeft(6);
		tree.left.left.right = new TreeNodeLeft(7);
		tree.left.right.right = new TreeNodeLeft(8);
		lzr.numNodesLeft(tree);
	}
}