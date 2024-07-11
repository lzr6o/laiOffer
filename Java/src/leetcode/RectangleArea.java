package leetcode;
class RectangleArea {
	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || B >= H || A >= G || D<= F) {
            return area;
        }
        int a = Math.min(C, G) - Math.max(A, E);
        int b = Math.min(D, H) - Math.max(B, F);
        int dup = a * b;
        return area - dup;
    }
	
	public static void main(String[] args) {
		RectangleArea lzr = new RectangleArea();
		int ax1, ay1, ax2, ay2, bx1, by1, bx2, by2;
		ax1 = -3;
		ay1 = 0;
		ax2 = 3;
		ay2 = 4;
		bx1 = 0;
		by1 = -1;
		bx2 = 9;
		by2 = 2;
		int area = lzr.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
		System.out.print(area);
	}
}