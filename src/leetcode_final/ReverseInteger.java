package leetcode_final;

/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Have you thought about this?
 * Here are some good questions to ask before coding.
 * Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be?
 * ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow?
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 */
public class ReverseInteger {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean neg = false;
		if (x < 0) {
			x = -x;
			neg = true;
		}
		int res = 0;
		while (x != 0) {
			res = 10 * res + x % 10;
			x /= 10;
		}
		return neg ? -res : res;
	}

	// Solution 2
	// (-123)%10 = - 3; (-123)/10 = -12
	public int reverse2(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		while (x != 0) {
			res = 10 * res + x % 10;
			x /= 10;
		}
		return res;
	}
	public static void main(String[] args){
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse2(-56));
	}
}
