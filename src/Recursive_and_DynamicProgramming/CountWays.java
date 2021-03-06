package Recursive_and_DynamicProgramming;

public class CountWays {

	public static void main(String[] args) {

	}

	public static int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
		}
		return map[n];
	}
}
