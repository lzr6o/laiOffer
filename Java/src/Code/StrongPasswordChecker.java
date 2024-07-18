package Code;
class StrongPasswordChecker {
	int strongPasswordChecker(String password) {
		int res = 0, n = password.length(), lower = 1, upper = 1, digit = 1;
		int[] arr = new int[n];
		for (int i = 0; i < n;) {
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				lower = 0;
			}
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				upper = 0;
			}
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				digit = 0;
			}
			int head = i;
			while (i < n && password.charAt(i) == password.charAt(head)) {
				i++;
			}
			arr[head] = i - head;
		}
		int missType = lower + upper + digit;
		if (n < 6) {
			res = Math.max(missType, 6 - n);
		} else {
			int over = Math.max(n - 20, 0), replace = 0;
			res += over;
			for (int i = 0; i < n && over > 0; i++) {
				if (arr[i] < 3) {
					continue;
				}
				if (arr[i] % 3 == 0) {
					arr[i] -= 1;
					over -= 1;
				}
			}
			for (int i = 0; i < n && over > 0; i++) {
				if (arr[i] < 3) {
					continue;
				}
				if (arr[i] % 3 == 1) {
					arr[i] -= Math.min(2, over);
					over -= 2;
				}
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] >= 3 && over > 0) {
					int needToRemove = arr[i] - 2;
					arr[i] -= over;
					over -= needToRemove;
				}
				if (arr[i] >= 3) {
					replace += arr[i] / 3;
				}
			}
			res += Math.max(missType, replace);
		}
		return res;
	}

	public static void main(String[] args) {
		StrongPasswordChecker lzr = new StrongPasswordChecker();
		String password = "aaaaaaaaaaaaAsaxqwd1aaaa";
		int res = lzr.strongPasswordChecker(password);
		System.out.print(res);
	}
}