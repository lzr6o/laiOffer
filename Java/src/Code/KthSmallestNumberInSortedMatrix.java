package Code;
import java.util.PriorityQueue;
import java.util.Comparator;

class KthSmallestNumberInSortedMatrix {
	class Cell {
		int row;
		int column;
		int value;
		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}
	int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});
		boolean[][] visited = new boolean[rows][columns];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
				minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}
			if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
				minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}
		return minHeap.peek().value;
	}
	
	public static void main(String[] args) {
		KthSmallestNumberInSortedMatrix lzr = new KthSmallestNumberInSortedMatrix();
		int[][] matrix = { {1, 3, 5, 7},
				           {2, 4, 8, 9},
				           {3, 5, 11, 15},
				           {6, 8, 13, 18} };
		int k = 8;
		int res = lzr.kthSmallest(matrix, k);
		System.out.print(res);
	}
}