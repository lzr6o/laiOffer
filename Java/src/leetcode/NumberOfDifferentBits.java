package leetcode;
class NumberOfDifferentBits {
	int diffBits(int a, int b) {
		a ^= b;
		int count = 0;
		while (a != 0) {
			count += a & 1;
			a >>>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		NumberOfDifferentBits lzr = new NumberOfDifferentBits();
		int a = 5;
		int b = 8;
		int result = lzr.diffBits(a, b);
		System.out.print(result);
	}
}