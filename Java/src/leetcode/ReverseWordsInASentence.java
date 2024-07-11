package leetcode;
class ReverseWordsInASentence {
	String reverseWords(String str) {
		char[] arr = str.toCharArray();
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
		ReverseWordsInASentence lzr = new ReverseWordsInASentence();
		String input = "I love Google";
		String res = lzr.reverseWords(input);
		System.out.print(res);
	}
}