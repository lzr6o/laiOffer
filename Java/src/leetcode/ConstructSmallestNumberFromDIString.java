package leetcode;

class ConstructSmallestNumberFromDIString {

	String smallestNumber(String pattern) {
		StringBuilder sb = new StringBuilder(), stack = new StringBuilder();
		for (int i = 0; i <= pattern.length(); i++) {
			stack.append((char) ('1' + i));
			if (i == pattern.length() || pattern.charAt(i) == 'I') {
				sb.append(stack.reverse());
				stack = new StringBuilder();
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ConstructSmallestNumberFromDIString lzr = new ConstructSmallestNumberFromDIString();
		String pattern = "DDDIII";
		String res = lzr.smallestNumber(pattern);
		System.out.print(res);
	}
}