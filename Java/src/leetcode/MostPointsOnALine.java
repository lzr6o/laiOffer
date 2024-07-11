package leetcode;
import java.util.HashMap;

class MostPointsOnALine {
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	int most(Point[] points) {
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Point seed = points[i];
			int same = 1;
			int sameX = 0;
			int most = 0;
			HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
			for (int j = i; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point tmp = points[j];
				if (tmp.x == seed.x && tmp.y == seed.y) {
					same++;
				} else if (tmp.x == seed.x) {
					sameX++;
				} else {
					double slope;
					if (tmp.y == seed.y) {
						slope = 0.0;
					} else {
						slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
					}
					if (!cnt.containsKey(slope)) {
						cnt.put(slope, 1);
					} else {
						cnt.put(slope, cnt.get(slope) + 1);
					}
					most = Math.max(most, cnt.get(slope));
				}
			}
			most = Math.max(most, sameX) + same;
			result = Math.max(result, most);
		}
		return result;
	}
	
	public static void main(String[] args) {
		MostPointsOnALine lzr = new MostPointsOnALine();
		Point[] points = { new Point(-5, 3), new Point(3, 3), new Point(2, 3) };
		int result = lzr.most(points);
		System.out.println(result);
	}
}