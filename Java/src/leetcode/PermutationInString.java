package leetcode;
class PermutationInString {
	boolean checkInclusion(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		if (n > m) {
			return false;
		}
		int[] arr = new int[26];
		for (char c : s1.toCharArray()) {
			arr[c - 'a']++;
		}
		int L = 0, R = 0;
		int cnt = n;
		while (R < m) {
			if (arr[s2.charAt(R++) - 'a']-- > 0) {
				cnt--;
			}
			while (cnt == 0) {
				if (R - L == n) {
					return true;
				}
				if (arr[s2.charAt(L++) - 'a']++ == 0) {
					cnt++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PermutationInString lzr = new PermutationInString();
		String s1 = "adc";
		String s2 = "dcda";
		boolean res = lzr.checkInclusion(s1, s2);
		System.out.println(res);
	}
}