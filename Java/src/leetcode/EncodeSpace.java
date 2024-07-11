package leetcode;

class EncodeSpace {

	final char[] SPACE_ENCODE = new char[] { '2', '0', '%' };

	String encode(String input) {
		if (input == null) {
			return input;
		}
		int spaces = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				spaces++;
			}
		}
		char[] res = new char[input.length() + spaces * 2];
		int j = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				res[j++] = input.charAt(i);
			} else {
				for (char c : SPACE_ENCODE) {
					res[j++] = c;
				}
			}
		}
		return new String(res);
	}

	public static void main(String[] args) {
		EncodeSpace lzr = new EncodeSpace();
		String input = "yahoo/q?flo wer mar  ket ";
		String result = lzr.encode(input);
		System.out.print(result);
	}
}