package LeetCode.ZigzagConversion;

class ZigZagConversion {
	String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			int jump = 2 * (numRows - 1);
			for (int j = i; j < s.length(); j+=jump) {
				sb.append(s.charAt(j));
				if (i > 0 && i < numRows - 1 && j + jump - 2 * i < s.length()) {
					sb.append(s.charAt(j + jump - 2 * i));
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion lzr = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String res = lzr.convert(s, numRows);
		System.out.print(res);
	}
}