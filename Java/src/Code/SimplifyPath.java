package Code;

import java.util.Stack;

class SimplifyPath {
	String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/");
		for (String p : paths) {
			if (!p.equals("") && !p.equals(".")) {
				if (p.equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else {
					stack.push(p);
				}
			}
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = '/' + stack.pop() + res;
		}
		return res.length() == 0 ? "/" : res;
	}

	public static void main(String[] args) {
		SimplifyPath lzr = new SimplifyPath();
		String path = "/../";
		String res = lzr.simplifyPath(path);
		System.out.print(res);
	}
}