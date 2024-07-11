package leetcode;
class ValidAnagram {
	boolean isAnagram(String s, String t) {
		int[] cnt = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			cnt[c - 'a']--;
		}
		for (int n : cnt) {
			if (n != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidAnagram lzr = new ValidAnagram();
		String s = "anagram";
		String t = "nagaram";
		boolean res = lzr.isAnagram(s, t);
		System.out.print(res);
	}
}