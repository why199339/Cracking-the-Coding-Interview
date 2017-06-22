package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 8, 0, 1, 2, 9 };
		heapSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void heapSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		buildHeap(nums);
		for (int i = nums.length - 1; i >= 1; i--) {
			exchange(nums, 0, i);
			maxHeap(nums, i, 0);
		}
	}

	private static void buildHeap(int[] nums) {
		int half = nums.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(nums, nums.length, i);
		}
	}

	private static void maxHeap(int[] nums, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int large = index;
		if (left < heapSize && nums[left] > nums[index]) {
			large = left;
		}
		if (right < heapSize && nums[right] > nums[large]) {
			large = right;
		}
		if (large != index) {
			exchange(nums, large, index);
			maxHeap(nums, heapSize, large);
		}
	}

	private static void exchange(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
