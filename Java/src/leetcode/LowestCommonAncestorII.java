package leetcode;
class LowestCommonAncestorII {
	class TreeNodeP {
		int key;
		TreeNodeP left;
		TreeNodeP right;
		TreeNodeP parent;
		TreeNodeP(int key, TreeNodeP parent) {
			this.key = key;
			this.parent = parent;
		}
	}
	
	TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		int l1 = length(one);
		int l2 = length(two);
		if (l1 <= l2) {
			return mergeNode(one, two, l2 - l1);
		} else {
			return mergeNode(two, one, l1 - l2);
		}
	}
	
	TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	
	int length(TreeNodeP node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.parent;
		}
		return length;
	}
	
	public static void main(String[] args) {
		LowestCommonAncestorII lzr = new LowestCommonAncestorII();
	}
}