package LeetCode.UglyNumber;

class UglyNumber {
	boolean isUgly(int n) {
		while (n > 1) {
			if (n % 5 == 0) {
				n = n / 5;
			} else if (n % 3 == 0) {
				n = n / 3;
			} else if (n % 2 == 0) {
				n = n / 2;
			} else {
				break;
			}
		}
		return n == 1;
	}

	public static void main(String[] args) {
		UglyNumber lzr = new UglyNumber();
		int n = 6;
		boolean res = lzr.isUgly(n);
		System.out.print(res);
	}
}