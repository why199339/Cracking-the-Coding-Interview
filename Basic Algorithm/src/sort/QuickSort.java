package sort;

public class QuickSort {

	public static void main(String[] args) {

	}

	public static void quickSort(int[] nums, int length, int low, int high) {
		if (nums == null || low == high) {
			return;
		}
		int index = Partition(nums, length, low, high);
		if (index > low) {
			quickSort(nums, length, low, index - 1);
		} else {
			quickSort(nums, length, index + 1, high);
		}
	}

	private static int Partition(int[] nums, int length, int low, int high) {
		if (nums == null || length <= 0 || low < 0 || high >= length) {
			System.out.println("Exception");
		}
		int index = (int) (low + Math.random() * (high - low + 1));
		int temp = nums[index];
		nums[index] = nums[high];
		nums[high] = temp;
		int small = low - 1;
		for (index = low; index < high; index++) {
			if (nums[index] < nums[high]) {
				small++;
				if (small != index) {
					temp = nums[index];
					nums[index] = nums[small];
					nums[small] = temp;
				}
			}
		}
		small++;
		temp = nums[small];
		nums[small] = nums[high];
		nums[high] = temp;
		return small;
	}
}
