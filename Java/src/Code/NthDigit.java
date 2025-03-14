package Code;

class NthDigit {
	int findNthDigit(int n) {
		int len = 1;
		long cnt = 9;
		int start = 1;
		while (n > len * cnt) {
			n -= len * cnt;
			len += 1;
			cnt *= 10;
			start *= 10;
		}
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

	public static void main(String[] args) {
		NthDigit lzr = new NthDigit();
		int n = 490;
		int res = lzr.findNthDigit(n);
		System.out.print(res);
	}
}