package Code;

class CountAndSay {

	String countAndSay(int n) {
		String ans = "1";
		if (n == 1) {
			return ans;
		}
		for (int i = 1; i < n; i++) {
			ans = getNext(ans);
		}
		return ans;
	}

	String getNext(String str) {
		char c = str.charAt(0);
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != c) {
				sb.append(cnt).append(c);
				c = str.charAt(i);
				cnt = 1;
			} else {
				cnt++;
			}
		}
		sb.append(cnt).append(c);
		return sb.toString();
	}

	public static void main(String[] args) {
		CountAndSay lzr = new CountAndSay();
		int n = 4;
		String res = lzr.countAndSay(n);
		System.out.print(res);
	}
}