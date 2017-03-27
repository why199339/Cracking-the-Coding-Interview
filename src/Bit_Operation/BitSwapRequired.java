package Bit_Operation;

public class BitSwapRequired {

	public static void main(String[] args) {

	}

	public static int bitSwapRequired(int a, int b) {
		int n = a ^ b;
		int count = 0;
		while (n > 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
