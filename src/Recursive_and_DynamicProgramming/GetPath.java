package Recursive_and_DynamicProgramming;

public class GetPath {

	public static void main(String[] args) {

	}

	public static int getPath(int m, int n) {
		int N = m + n - 2;
		int k = m - 1;
		double res = 0;
		for (int i = 1; i <= k; i++) {
			res = (double) (res * (N - k + i) / i);
		}
		return (int) Math.round(res);
	}

	public static int getPath_obstacle(int[][] obstacles) {
		if (obstacles == null) {
			return 0;
		}
		int[] dp = new int[obstacles[0].length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		for (int[] row : obstacles) {
			for (int j = 1; j < dp.length; j++) {
				if (row[j] == 1) {
					dp[j] = 0;
				} else {
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[dp.length - 1];
	}
}
