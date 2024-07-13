package IP报文头解析;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
	private static String getIpData(String input) {
		String[] arr = input.split(" ");
		int len = Integer.parseInt(arr[2] + arr[3], 16);
		String logo = Integer.toBinaryString(Integer.parseInt(arr[6], 16));
		logo = logo.substring(0, logo.length() - 5);
		Integer.parseInt(logo, 2);
		String ip = Integer.parseInt(arr[16], 16) + "." + Integer.parseInt(arr[17], 16) + "."
				+ Integer.parseInt(arr[18], 16) + "." + Integer.parseInt(arr[19], 16);
		return len + "," + logo + "," + ip;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
		String input = cin.nextLine().trim();

		cin.close();
		System.out.println(getIpData(input));
	}
}

// 45 00 10 3c 7c 48 20 03 80 06 00 00 c0 a8 01 02 c0 a8 14 b8