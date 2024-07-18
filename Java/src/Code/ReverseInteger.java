package Code;

class ReverseInteger {
	
	int reverse(int x) {
		int res = 0;
		int neg = x < 0 ? -1 : 1;
		x = Math.abs(x);
		while (x != 0) {
			if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE - res * 10 < x / 10) {
				return 0;
			}
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res * neg;
	}

	public static void main(String[] args) {
		ReverseInteger lzr = new ReverseInteger();
		int x = 222222222;
		int res = lzr.reverse(x);
		System.out.print(res);
	}
}