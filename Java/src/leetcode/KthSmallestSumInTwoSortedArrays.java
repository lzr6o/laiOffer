package leetcode;
import java.util.PriorityQueue;
import java.util.Comparator;

class KthSmallestSumInTwoSortedArrays {
	class Cell {
		int aIndex;
		int bIndex;
		int value;
		Cell(int aIndex, int bIndex) {
			this.aIndex = aIndex;
			this.bIndex = bIndex;
		}
	}
	
	int kthSum(final int[] A, final int[] B, int k) {
		int aLen = A.length;
		int bLen = B.length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				int c1sum = A[c1.aIndex] + B[c1.bIndex];
				int c2sum = A[c2.aIndex] + B[c2.bIndex];
				if (c1sum == c2sum) {
					return 0;
				}
				return c1sum < c2sum ? -1 : 1;
			}
		});

		boolean[][] visited = new boolean[A.length][B.length];
		minHeap.offer(new Cell(0, 0));
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.aIndex + 1 < aLen && !visited[cur.aIndex + 1][cur.bIndex]) {
				minHeap.offer(new Cell(cur.aIndex + 1, cur.bIndex));
				visited[cur.aIndex + 1][cur.bIndex] = true;
			}
			if (cur.bIndex + 1 < bLen && !visited[cur.aIndex][cur.bIndex + 1]) {
				minHeap.offer(new Cell(cur.aIndex, cur.bIndex + 1));
				visited[cur.aIndex][cur.bIndex + 1] = true;
			}
		}
		Cell result = minHeap.peek();
		return A[result.aIndex] + B[result.bIndex];
	}
	
	public static void main(String[] args) {
		KthSmallestSumInTwoSortedArrays lzr = new KthSmallestSumInTwoSortedArrays();
		int[] A = { 1, 3, 5 };
		int[] B = { 4, 8 };
		int k = 1;
		int result = lzr.kthSum(A, B, k);
		System.out.print(result);
	}
}