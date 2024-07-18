package Code;
class RemoveKDigits {
	String removeKdigits(String num, int k) {
		if (num.length() == 0 || num == null) {
			return num;
		}
		int len = num.length();
		int remainingDigit = len - k;
		char[] stack = new char[len];
		int top = 0;
		for (int i = 0; i < len; i++) {
			char c = num.charAt(i);
			while (top > 0 && k > 0 && c < stack[top - 1]) {
				top--;
				k--;
			}
			stack[top++] = c;
		}
		int idx = 0;
		while (idx < remainingDigit && stack[idx] == '0') {
			idx++;
		}
		return idx == remainingDigit ? "0" : new String(stack, idx, remainingDigit - idx);
	}

	public static void main(String[] args) {
		RemoveKDigits lzr = new RemoveKDigits();
		String num = "12354";
		int k = 4;
		String res = lzr.removeKdigits(num, k);
		System.out.print(res);
	}
}