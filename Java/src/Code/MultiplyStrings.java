package Code;

class MultiplyStrings {
	
	String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int x = num1.charAt(i) - '0', y = num2.charAt(j) - '0';
				int p1 = i + j, p2 = i + j + 1;
				int sum = x * y + pos[p2] + pos[p1] * 10;
				pos[p1] = sum / 10;
				pos[p2] = (sum) % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int p : pos) {
			if (!(sb.length() == 0 && p == 0)) {
				sb.append(p);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings lzr = new MultiplyStrings();
		String num1 = "123";
		String num2 = "456";
		String res = lzr.multiply(num1, num2);
		System.out.print(res);
	}
}