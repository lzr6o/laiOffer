package Code;

class AToThePowerOfB {

	// 输入
	// int a : base number
	// int b ：index or power
	// 输出
	// long : a^b
	// assumption: b >= 0.
	long power(int a, int b) {
		// base case 1
		// 如果b为0，不管a是多少，结果都为1 (a^0=1)
		if (b == 0) {
			 return 1;
		}
		// base case 2
		// 如果a为0，不管b是多少，结果都为0 (0^b=0)
		if (a == 0) {
			return 0;
		}
		// recursive rule
		// 如果当前call stack层中b可以整除2，返回power(a, b/2)*power(a, b/2)的值到上一层
		// 不能整除2的话，返回power(a, b/2)*power(a, b/2)*a的值到上一层
		long half = power(a, b / 2);
		System.out.println("a = " + a + ", b = " + b + ", half = " + half);
		return b % 2 == 0 ? half * half : half * half * a;
	}
	
	public static void main(String[] args) {
		AToThePowerOfB test = new AToThePowerOfB();
		long result = test.power(2, 4);
		System.out.println(result);
	}
}