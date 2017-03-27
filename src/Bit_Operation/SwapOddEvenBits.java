package Bit_Operation;

public class SwapOddEvenBits {

	public static void main(String[] args) {

	}

	public static int swapOddEvenBits(int n) {
		int mask1 = 0xaaaaaaa;
		int mask2 = 0x5555555;
		return ((n & mask1) >> 1) | ((n & mask2) << 1);
	}
}
