package leetcode;

class ValidParenthesisString {

	boolean checkValidString(String s) {
        int lMin = 0, lMax = 0;
        for (Character c : s.toCharArray()) {
        	if (c == '(') {
        		lMin++;
        		lMax++;
        	} else if (c == ')') {
        		lMin--;
        		lMax--;
        	} else {
        		lMin--;
        		lMax++;
        	}
        	if (lMax < 0) {
        		return false;
        	}
        	if (lMin < 0) {
        		lMin = 0;
        	}
        }
        return lMin == 0;
    }
	
	public static void main(String[] args) {
		ValidParenthesisString lzr = new ValidParenthesisString();
		String s = "(*))";
		boolean res = lzr.checkValidString(s);
		System.out.print(res);
	}
}