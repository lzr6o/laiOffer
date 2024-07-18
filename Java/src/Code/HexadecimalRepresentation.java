package Code;

class HexadecimalRepresentation {
	String hex(int num) {
		String prefix = "0x";
		if (num == 0) {
			return prefix + "0";
		}
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int rem = num % 16;
			if (rem < 10) {
				sb.append((char) ('0' + rem));
			} else {
				sb.append((char) (rem - 10 + 'A'));
			}
			num >>>= 4;
		}
		return prefix + sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		HexadecimalRepresentation lzr = new HexadecimalRepresentation();
		int num = 255;
		String res = lzr.hex(num);
		System.out.print(res);
	}
}