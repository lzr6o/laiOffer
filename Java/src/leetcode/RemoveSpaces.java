package leetcode;
class RemoveSpaces {
	String removeSpaces(String str) {
		if (str.isEmpty()) {
			return str;
		}
		char[] arr = str.toCharArray();
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ')) {
				continue;
			}
			arr[end++] = arr[i];
		}
		if (end > 0 && arr[end - 1] == ' ') {
			end--;
		}
		return new String(arr, 0, end);
	}
	
	public static void main(String args[]) {
		RemoveSpaces lzr = new RemoveSpaces();
		String input = "  cao  ni  ma  ";
		String res = lzr.removeSpaces(input);
		System.out.print(res);
	}
}