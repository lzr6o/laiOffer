package leetcode;

class LengthOfLastWord {
	int lengthOfLastWord(String s) {
		int len = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				len++;
			} else {
				if (len > 0) {
					return len;
				}
			}
		}
		return len;
	}

	public static void main(String[] args) {
		LengthOfLastWord lzr = new LengthOfLastWord();
		String s = "   fly me   to   the moon  ";
		int res = lzr.lengthOfLastWord(s);
		System.out.print(res);
	}
}