package sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 9, 1, 2, 8, 0 };
		radixSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void radixSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int maxNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxNum = Math.max(maxNum, nums[i]);
		}
		int exp = 1;
		int base = 10;
		int[] aux = new int[nums.length];
		while (maxNum / exp > 0) {
			int[] count = new int[base];
			for (int i = 0; i < nums.length; i++) {
				count[nums[i] / exp % 10]++;
			}
			for (int i = 1; i < count.length; i++) {
				count[i] = count[i - 1] + count[i];
			}
			for (int i = nums.length - 1; i >= 0; i--) {
				aux[--count[nums[i] / exp % 10]] = nums[i];
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = aux[i];
			}
			exp = exp * 10;
		}
	}
}
