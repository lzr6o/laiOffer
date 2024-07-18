package Code;
import java.util.ArrayList;
import java.util.List;

class RestoreIPAddress {
	List<String> Restore(String ip) {
		List<String> result = new ArrayList<String>();
		if (ip == null || ip.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(ip.toCharArray(), 0, 0, sb, result);
		return result;
	}
	void helper(char[] ip, int level, int offset, StringBuilder sb, List<String> result) {
		if (level == 4) {
			if (sb.length() == ip.length + 4) {
				result.add(sb.substring(0, sb.length() - 1));
			}
			return;
		}
		if (offset < ip.length) {
			helper(ip, level + 1, offset + 1, sb.append(ip[offset]).append('.'), result);
			sb.delete(sb.length() - 2, sb.length());
		}
		if (offset + 1 < ip.length) {
			char a = ip[offset];
			char b = ip[offset + 1];
			if (a != '0') {
				helper(ip, level + 1, offset + 2, sb.append(a).append(b).append('.'), result);
				sb.delete(sb.length() - 3, sb.length());
			}
		}
		if (offset + 2 < ip.length) {
			char a = ip[offset];
			char b = ip[offset + 1];
			char c = ip[offset + 2];
			if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
				helper(ip, level + 1, offset + 3, sb.append(a).append(b).append(c).append('.'), result);
				sb.delete(sb.length() - 4, sb.length());
			}
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddress lzr = new RestoreIPAddress();
		String ip = "25525511135";
		List<String> result = lzr.Restore(ip);
		System.out.print(result);
	}
}