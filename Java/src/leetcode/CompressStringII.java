package leetcode;

class CompressStringII {
	String compress(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		char[] arr = input.toCharArray();
		return encode(arr);
	}

	String encode(char[] arr) {
		int slow = 0;
		int fast = 0;
		int newLen = 0;
		while (fast < arr.length) {
			int head = fast;
			while (fast < arr.length && arr[fast] == arr[head]) {
				fast++;
			}
			arr[slow++] = arr[head];
			if (fast - head == 1) {
				newLen += 2;
			} else {
				int len = copyDigits(arr, slow, fast - head);
				slow += len;
				newLen += len + 1;
			}
		}
		char[] res = new char[newLen];
		fast = slow - 1;
		slow = newLen - 1;
		while (fast >= 0) {
			if (Character.isDigit(arr[fast])) {
				while (fast >= 0 && Character.isDigit(arr[fast])) {
					res[slow--] = arr[fast--];
				}
			} else {
				res[slow--] = '1';
			}
			res[slow--] = arr[fast--];
		}
		return new String(res);
	}

	int copyDigits(char[] arr, int idx, int cnt) {
		int len = 0;
		for (int i = cnt; i > 0; i /= 10) {
			idx++;
			len++;
		}
		for (int i = cnt; i > 0; i /= 10) {
			int digit = i % 10;
			arr[--idx] = (char) ('0' + digit);
		}
		return len;
	}

	public static void main(String args[]) {
		CompressStringII lzr = new CompressStringII();
		String input = "abbcccdeee";
		String res = lzr.compress(input);
		System.out.print(res);
	}
}