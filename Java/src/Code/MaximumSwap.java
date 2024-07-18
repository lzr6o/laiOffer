package Code;
class MaximumSwap {
	int maximumSwap(int num) {
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        int head = -1, tail = 0;
        char max = '0';
        for (int i = 1; i < arr.length; i++) {
        	if (head == -1 && arr[i] >= arr[i - 1]) {
        		head = i - 1;
        		max = arr[head];
        	}
        	if (head != -1 && arr[i] > max) {
        		max = arr[i];
        		tail = i;
        	}
        }
        if (head != - 1) {
        	char tmp = arr[head];
        	arr[head] = arr[tail];
        	arr[tail] = tmp;
        }
        return Integer.parseInt(new String(arr));
    }
	
	public static void main(String[] args) {
		MaximumSwap lzr = new MaximumSwap();
		int num = 115;
		int res = lzr.maximumSwap(num);
		System.out.print(res);
	}
}