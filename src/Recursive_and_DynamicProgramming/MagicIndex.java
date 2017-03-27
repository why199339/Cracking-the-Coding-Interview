package Recursive_and_DynamicProgramming;

public class MagicIndex {

	public static void main(String[] args) {

	}

	public static int MagicIndex_noDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return MagicIndex_noDuplicate(nums, 0, 0);
	}

	private static int MagicIndex_noDuplicate(int[] nums, int start, int end) {
		if (start > end || start < 0 || end > nums.length) {
			return -1;
		}
		int mid = start + (end - start) >> 1;
		if (nums[mid] == mid) {
			return mid;
		}
		if (nums[mid] > mid) {
			return MagicIndex_noDuplicate(nums, start, mid - 1);
		} else {
			return MagicIndex_noDuplicate(nums, mid + 1, end);
		}
	}

	public static int MagicIndex_Duplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return MagicIndex_Duplicate(nums, 0, nums.length - 1);
	}

	private static int MagicIndex_Duplicate(int[] nums, int start, int end) {
		if (start > end || start < 0 || end > nums.length) {
			return -1;
		}
		int midIndex = start + (end - start) >> 1;
		int midValue = nums[midIndex];
		if (midIndex == midValue) {
			return midIndex;
		}
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = MagicIndex_Duplicate(nums, start, leftIndex);
		if (left > 0) {
			return left;
		}
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = MagicIndex_Duplicate(nums, rightIndex, end);
		return right;
	}
}
