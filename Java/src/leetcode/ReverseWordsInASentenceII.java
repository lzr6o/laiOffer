package leetcode;
class ReverseWordsInASentenceII {
	String reverseWords(String str) {
		String newStr = removeSpaces(str);
		char[] arr = newStr.toCharArray();
		reverse(arr, 0, arr.length - 1);
		int head = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
				head = i;
			}
			if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
				reverse(arr, head, i);
			}
		}
		return new String(arr);
	}
	
	String removeSpaces(String str) {
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
	
	void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String args[]) {
		ReverseWordsInASentenceII lzr = new ReverseWordsInASentenceII();
		String input = " I  love  Google ";
		String result = lzr.reverseWords(input);
		System.out.print(result);
	}
}