package Code;

class DecompressString {

	String decompress(String str) {
		if (str.isEmpty()) {
			return str;
		}
		char[] charArr = str.toCharArray();
		return decode(charArr);
	}
	
	String decode(char[] charArr) {
		int newLen = charArr.length;
		for (int i = 0; i < charArr.length; i++) {
			int digit = getDigit(charArr[i]);
			if (digit > 2 && digit <= 9) {
				newLen += digit - 2;
			}
		}
		char[] newStr = new char[newLen];
		int end = newLen - 1;
		for (int i = charArr.length - 1; i >= 0; i--) {
			int digit = getDigit(charArr[i]);
			if (digit >= 2 && digit <= 9) {
				i--;
				for (int j = 0; j < digit; j++) {
					newStr[end--] = charArr[i];
				}
			} else {
				newStr[end--] = charArr[i];
			}
		}
		return new String(newStr);
	}
	
	int getDigit(char digit) {
		return digit - '0';
	}
	
	public static void main(String args[]) {
		DecompressString lzr = new DecompressString();
		String input = "a3";
		String result = lzr.decompress(input);
		System.out.print(result);
	}
}