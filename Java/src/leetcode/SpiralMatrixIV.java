package leetcode;

import java.util.Arrays;

class SpiralMatrixIV {
	ListNode constructLinkedList(int[] arr) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int num : arr) {
			ListNode node = new ListNode(num);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}

	int[][] spiralMatrix(int m, int n, ListNode head) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; ++i) {
			Arrays.fill(res[i], -1);
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0, y = 0, dir = 0;
		while (head != null) {
			res[x][y] = head.val;
			head = head.next;
			if (head != null) {
				while (x + dirs[dir][0] < 0 || x + dirs[dir][0] == m || y + dirs[dir][1] < 0 || y + dirs[dir][1] == n
						|| res[x + dirs[dir][0]][y + dirs[dir][1]] != -1) {
					dir++;
					dir %= 4;
				}
				x += dirs[dir][0];
				y += dirs[dir][1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SpiralMatrixIV lzr = new SpiralMatrixIV();
		int m = 3;
		int n = 5;
		int[] arr = { 3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 };
		ListNode head = lzr.constructLinkedList(arr);
		int[][] res = lzr.spiralMatrix(m, n, head);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}