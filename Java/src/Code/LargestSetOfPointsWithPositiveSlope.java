package Code;
import java.util.Arrays;
import java.util.Comparator;

class LargestSetOfPointsWithPositiveSlope {
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int largest(Point[] points) {
		Arrays.sort(points, new MyComparator());
		int res = 0;
		int[] dp = new int[points.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (points[j].y < points[i].y) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i]++;
			res = Math.max(res, dp[i]);
		}
		return res == 1 ? 0 : res;
	}

	class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			return p1.x != p2.x ? p1.x - p2.x : p2.y - p1.y;
		}
	}

	public static void main(String[] args) {
		LargestSetOfPointsWithPositiveSlope lzr = new LargestSetOfPointsWithPositiveSlope();
		Point one = new Point(0, 0);
		Point two = new Point(1, 1);
		Point three = new Point(2, 3);
		Point four = new Point(3, 3);
		Point[] points = { one, two, three, four };
		int res = lzr.largest(points);
		System.out.print(res);
	}
}