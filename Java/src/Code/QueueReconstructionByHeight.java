package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class QueueReconstructionByHeight {
	int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
			}
		});
		List<int[]> ans = new ArrayList<int[]>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[ans.size()][]);
	}

	public static void main(String[] args) {
		QueueReconstructionByHeight lzr = new QueueReconstructionByHeight();
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] res = lzr.reconstructQueue(people);
		for (int[] arr : res) {
			System.out.print(Arrays.toString(arr) + " ");
		}
	}
}