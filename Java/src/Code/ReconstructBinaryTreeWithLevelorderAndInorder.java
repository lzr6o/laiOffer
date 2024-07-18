package Code;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReconstructBinaryTreeWithLevelOrderAndInOrder {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode reconstruct(int[] in, int[] level) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		List<Integer> lList = new ArrayList<Integer>();
		for (int num : level) {
			lList.add(num);
		}
		return helper(lList, inMap);
	}
	
	TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
		if (level.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(level.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int num : level) {
			if (inMap.get(num) < inMap.get(root.key)) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
		root.left = helper(left, inMap);
		root.right = helper(right, inMap);
		return root;
	}
	
	public static void main(String[] args) {
		ReconstructBinaryTreeWithLevelOrderAndInOrder lzr = new ReconstructBinaryTreeWithLevelOrderAndInOrder();
		int[] in = { 1, 3, 4, 5, 8, 11 };
		int[] level = { 5, 3, 8, 1, 4, 11 };
		TreeNode tree = lzr.reconstruct(in, level);
	}
}