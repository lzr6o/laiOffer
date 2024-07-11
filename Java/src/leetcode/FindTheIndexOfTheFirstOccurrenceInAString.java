package leetcode;

class FindTheIndexOfTheFirstOccurrenceInAString {
	int strStr(String haystack, String needle) {
		int lenH = haystack.length(), lenN = needle.length(), ret = -1;
		for (int i = 0; i <= (lenH - lenN); i++) {
			for (int j = 0; j < lenN; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					ret = -1;
					break;
				}
				ret = i;
			}
			if (ret >= 0) {
				return ret;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		FindTheIndexOfTheFirstOccurrenceInAString lzr = new FindTheIndexOfTheFirstOccurrenceInAString();
		String haystack = "ababcaababcaabc", needle = "ababcaabc";
		int res = lzr.strStr(haystack, needle);
		System.out.print(res);
	}
}