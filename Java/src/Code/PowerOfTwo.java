package Code;

class PowerOfTwo {
	boolean isPowerOfTwo(int num) {
		return num > 0 && (num & (num - 1)) == 0;
	}
	
	public static void main(String[] args) {
		PowerOfTwo lzr = new PowerOfTwo();
		int num = 16;
		boolean res = lzr.isPowerOfTwo(num);
		System.out.print(res);
	}
}