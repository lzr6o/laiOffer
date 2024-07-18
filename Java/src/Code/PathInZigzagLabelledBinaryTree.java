package Code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PathInZigzagLabelledBinaryTree {
	List<Integer> pathInZigZagTree(int label) {
		int twos = 2, level = 0;
		while (label > twos - 1) {
			twos *= 2;
			level++;
		}
		int idx = 0;
		List<Integer> res = new ArrayList<>();
		if (level % 2 == 0) {
			idx = label - twos / 2;
		} else {
			idx = twos - label - 1;
		}
		while (level >= 0) {
			if (level % 2 == 0) {
				res.add(twos / 2 + idx);
			} else {
				res.add(twos - 1 - idx);
			}
			idx /= 2;
			level--;
			twos /= 2;
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		PathInZigzagLabelledBinaryTree lzr = new PathInZigzagLabelledBinaryTree();
		int label = 12;
		List<Integer> res = lzr.pathInZigZagTree(label);
		System.out.print(res);
	}
}