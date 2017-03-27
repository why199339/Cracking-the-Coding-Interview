package Bit_Operation;

public class UpdateBits {

	public static void main(String[] args) {

	}

	public static int updates(int n, int m, int i, int j) {
		int allOnes = ~0;
		int left = allOnes << (i + 1);
		int right = (1 << j) - 1;
		int mask = left | right;
		int nCleared = mask & n;
		int mShifted = m << i;
		int result = nCleared | mShifted;
		return result;
	}
}
