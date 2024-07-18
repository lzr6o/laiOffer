package Code;

class CustomSortString {

	String customSortString(String order, String s) {
		int[] cnt = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			while (cnt[c - 'a'] > 0) {
				sb.append(c);
				cnt[c - 'a']--;
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i] > 0) {
				sb.append(((char) (i + 'a')));
				cnt[i]--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		CustomSortString lzr = new CustomSortString();
		String order = "cba";
		String s = "abcd";
		String res = lzr.customSortString(order, s);
		System.out.print(res);
	}
}