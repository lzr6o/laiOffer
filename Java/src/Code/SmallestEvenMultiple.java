package Code;

class SmallestEvenMultiple {
	int smallestEvenMultiple(int n) {
		return n % 2 == 0 ? n : n * 2;
	}

	public static void main(String[] args) {
		SmallestEvenMultiple lzr = new SmallestEvenMultiple();
		int n = 5;
		int res = lzr.smallestEvenMultiple(n);
		System.out.print(res);
	}
}