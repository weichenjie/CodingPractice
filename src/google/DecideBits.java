package google;

/*
 * Given a byte array, which is an encoding of characters. Here is the rule:
 a. If the first bit of a byte is 0, that byte stands for a one-byte character
 b. If the first bit of a byte is 1, that byte and its following byte together stand for a two-byte character
Now implement a function to decide if the last character is a one-byte character or a two-byte character
Constraint: You must scan the byte array from the end to the start. Otherwise it will be very trivial.

 */
public class DecideBits {
	public static String decide(int[] array) {
		int len = array.length;
		if (array[len - 1] == 1)
			return "two-byte char";
		int counter = 0;
		for (int i = len - 2; i >= 0 && array[i] == 1; i--)
			counter++;

		if (counter % 2 != 0) {
			return "single-type char";
		} else {
			return "two-byte char";
		}
	}
}
