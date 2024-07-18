package Code;
class ReverseBitsOf32BitInteger {
	long reversBits(long num) {
		for (int offset = 0; offset < 16; ++offset) {
			long right = (num >> offset) & 1L;
			long left = (num >> (31 - offset)) & 1L;
			if (left != right) {
				num ^= (1L << offset);
				num ^= (1L << (31 - offset));
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		ReverseBitsOf32BitInteger lzr = new ReverseBitsOf32BitInteger();
		long num = 1234;
		long result = lzr.reversBits(num);
		System.out.print(result);
	}
}