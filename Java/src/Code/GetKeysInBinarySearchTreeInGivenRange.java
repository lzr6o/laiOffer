package Code;

import java.util.ArrayList;
import java.util.List;

class GetKeysInBinarySearchTreeInGivenRange {
	List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> list = new ArrayList<>();
		getRange(root, min, max, list);
		return list;
	}
	
	void getRange(TreeNode root, int min, int max, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.val > min) {
			getRange(root.left, min, max, list);
		}
		if (root.val >= min && root.val <= max) {
			list.add(root.val);
		}
		if (root.val < max) {
			getRange(root.right, min, max, list);
		}
	}
	
	public static void main(String args[]) {
		GetKeysInBinarySearchTreeInGivenRange lzr = new GetKeysInBinarySearchTreeInGivenRange();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(4);
		tree.right.right = new TreeNode(11);
		List<Integer> result = lzr.getRange(tree, 2, 5);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}