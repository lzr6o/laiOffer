package Code;

class Demo {
	int solution(int[] tileColors, int size) {
		int len = tileColors.length;
		int res = 0;
		int cur = 1;
		for (int i = 1; i < len + size - 1; i++) {
			if (tileColors[i % len] != tileColors[(i - 1) % len]) {
				cur++;
			} else if (cur >= size) {
				res += cur - size + 1;
				cur = 1;
			} else {
				cur = 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Demo lzr = new Demo();
		int[] titleColors = { 0, 1, 0, 1, 1,         0 , 1 };
		int size = 3;
		int res = lzr.solution(titleColors, size);
		System.out.print(res);
	}
}