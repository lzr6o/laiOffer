package Code;

import java.util.HashSet;
import java.util.Set;

class UniqueEmailAddresses {
	int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			String local = email.split("@")[0], domain = email.split("@")[1];
			local = local.split("\\+")[0].replace(".", "");
			set.add(local + "@" + domain);
		}
		return set.size();
	}

	public static void main(String[] args) {
		UniqueEmailAddresses lzr = new UniqueEmailAddresses();
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		int res = lzr.numUniqueEmails(emails);
		System.out.print(res);
	}
}