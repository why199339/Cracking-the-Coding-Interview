package Bit_Operation;

import java.util.Arrays;

public class findMissing {

	public static void main(String[] args) {

	}

	public static int findMissing_xor(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ i;
			res = res ^ nums[i];
		}
		return res;
	}

	public static int findMissing_sum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i;
			sum -= nums[i];
		}
		sum += nums.length;
		return sum;
	}

	public static int binarySearch(int[] nums) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > mid) {
				right = mid;
			} else {
				left = left + 1;
			}
		}
		return left;
	}
}
