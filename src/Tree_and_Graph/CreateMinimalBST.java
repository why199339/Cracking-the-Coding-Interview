package Tree_and_Graph;

public class CreateMinimalBST {

	public static void main(String[] args) {

	}

	public static TreeNode createMinimalBST(int[] nums, int start, int end) {
		if(end < start) {
			return null;
		}
		int mid = start + (end - start) >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createMinimalBST(nums, start, mid - 1);
		root.right = createMinimalBST(nums, mid + 1, end);
		return root;
	}
}
