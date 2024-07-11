package leetcode;
class PowerOfTwo {
	boolean isPowerOfTwo(int number) {
		return number > 0 && (number & (number - 1)) == 0;
	}
	
	public static void main(String[] args) {
		PowerOfTwo lzr = new PowerOfTwo();
		int number = 16;
		boolean result = lzr.isPowerOfTwo(number);
		System.out.print(result);
	}
}