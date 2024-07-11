package leetcode;

class FibonacciNumber {

	long fibonacci(int K) {
		long a = 0;
		long b = 1;
		if (K <= 0) {
			return a;
		}
		while (K > 1) {
			long temp = a + b;
			a = b;
			b = temp;
			K--;
		}
		return b;
	}
	
	public static void main(String[] args) {
		FibonacciNumber lzr = new FibonacciNumber();
		int K = 6;
		long result = lzr.fibonacci(K);
		System.out.print(result);
	}
}