package Code;
import java.util.PriorityQueue;
import java.util.Arrays;

class KClosestPointsToOrigin {
	int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
	    for (int[] p : points) {
	        pq.offer(p);
	        if (pq.size() > k) {
	            pq.poll();
	        }
	    }
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		KClosestPointsToOrigin lzr = new KClosestPointsToOrigin();
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		int[][] res = lzr.kClosest(points, k);
		for (int[] p : res) {
			System.out.print(Arrays.toString(p) + " ");
		}
	}
}