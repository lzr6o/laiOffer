package leetcode;

class FirstUniqueCharacterInAString {

	int firstUniqChar(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInAString lzr = new FirstUniqueCharacterInAString();
		String str = "leetcode";
		int res = lzr.firstUniqChar(str);
		System.out.print(res);
	}
}