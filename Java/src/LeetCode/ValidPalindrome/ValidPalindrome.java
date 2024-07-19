package LeetCode.ValidPalindrome;
class ValidPalindrome {
	boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int L = 0, R = s.length() - 1;
		while (L < R) {
			while (L < R && !Character.isLetterOrDigit(s.charAt(L))) {
				L++;
			}
			while (L < R && !Character.isLetterOrDigit(s.charAt(R))) {
				R--;
			}
			if (s.charAt(L++) != s.charAt(R--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome lzr = new ValidPalindrome();
		String s = "0P";
		boolean res = lzr.isPalindrome(s);
		System.out.print(res);
	}
}