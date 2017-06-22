package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 8, 0, 1, 2, 9 };
		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void mergeSort(int[] nums, int low, int high) {
		if (nums == null || nums.length == 0) {
			return;
		}
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
	}

	private static void merge(int[] nums, int low, int mid, int high) {
		int[] newNums = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				newNums[k] = nums[i];
				i++;
				k++;
			}
			else {
				newNums[k] = nums[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			newNums[k] = nums[i];
			i++;
			k++;
		}
		while (j <= high) {
			newNums[k] = nums[j];
			j++;
			k++;
		}
		for (int index = 0; index < newNums.length; index++) {
			nums[low + index] = newNums[index];
		}
	}
}
