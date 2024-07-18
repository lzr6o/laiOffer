package Code;

class StringAbbreviationMatching {
	boolean match(String input, String pattern) {
		int si = 0;
		int ti = 0;
		while (si < input.length() && ti < pattern.length()) {
			if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
				if (input.charAt(si) != pattern.charAt(ti)) {
					return false;
				}
				si++;
				ti++;
			} else {
				int cnt = 0;
				while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
					cnt = cnt * 10 + (pattern.charAt(ti) - '0');
					ti++;
				}
				si += cnt;
			}
		}
		return si == input.length() && ti == pattern.length();
	}
	
	public static void main(String[] args) {
		StringAbbreviationMatching lzr = new StringAbbreviationMatching();
		String input = "sophisticated";
		String pattern = "s11d";
		boolean result = lzr.match(input, pattern);
		System.out.print(result);
	}
}