package Recursive_and_DynamicProgramming;

import java.util.HashSet;

public class NQueens {

	private static HashSet<Integer> colSet = new HashSet<>();
	private static HashSet<Integer> diag1Set = new HashSet<>();
	private static HashSet<Integer> diag2Set = new HashSet<>();

	public static void main(String[] args) {

	}

	public static int nQueens_1(int n) {
		return nQueensHelper(0, 0, n);
	}

	private static int nQueensHelper(int row, int count, int n) {
		for (int col = 0; col < n; col++) {
			if (colSet.contains(col)) {
				continue;
			}
			int diag1 = row - col;
			if (diag1Set.contains(diag1)) {
				continue;
			}
			int diag2 = row + col;
			if (diag2Set.contains(diag2)) {
				continue;
			}
			if (row == n - 1) {
				count++;
			} else {
				colSet.add(col);
				diag1Set.add(row - col);
				diag2Set.add(row + col);
				count = nQueensHelper(row + 1, count, n);
				colSet.remove(col);
				diag1Set.remove(row - col);
				diag2Set.remove(row + col);
			}
		}
		return count;
	}

	public static int nQueens_2(int n) {
		if (n == 0) {
			return 0;
		}
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		int[] count = { 0 };
		nQueensCore(nums, 0, count);
		return count[0];
	}

	private static void nQueensCore(int[] nums, int index, int[] count) {
		if (index == nums.length - 1) {
			boolean isResult = true;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if ((j - i) == nums[j] - nums[i] || (i - j) == nums[j] - nums[i]) {
						isResult = false;
						break;
					}
				}
			}
			if (isResult) {
				count[0]++;
			}
			return;
		} else {
			for (int i = index; i < nums.length; i++) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				nQueensCore(nums, index + 1, count);
				temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}
	}
}
