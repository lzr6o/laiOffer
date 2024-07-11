package leetcode;

class FibonacciNumberLite {

	long fibonacci(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		return fibonacci(k - 1) + fibonacci(k - 2);
	}
	
	public static void main(String[] args) {
		FibonacciNumberLite lzr = new FibonacciNumberLite();
		int k = 6;
		long res = lzr.fibonacci(k);
		System.out.print(res);
	}
}