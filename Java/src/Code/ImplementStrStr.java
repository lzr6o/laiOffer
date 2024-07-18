package Code;
class ImplementStrStr {
	int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		ImplementStrStr lzr = new ImplementStrStr();
		String haystack = "hello";
		String needle = "ll";
		int res = lzr.strStr(haystack, needle);
		System.out.print(res);
	}
}