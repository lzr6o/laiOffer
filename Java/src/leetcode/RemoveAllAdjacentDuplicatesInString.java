package leetcode;

import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
	String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
        	if (stack.isEmpty() || stack.peek() != c) {
        		stack.push(c);
        	} else {
        		stack.pop();
        	}
        }
        String res = "";
        while (!stack.isEmpty()) {
        	res = stack.pop() + res;
        }
        return res;
    }
	
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInString lzr = new RemoveAllAdjacentDuplicatesInString();
		String s= "abbaca";
		String res = lzr.removeDuplicates(s);
		System.out.print(res);
	}
}