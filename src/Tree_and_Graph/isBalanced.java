package Tree_and_Graph;

public class isBalanced {

	public static void main(String[] args) {

	}

	public static boolean isBalanced_1(TreeNode root) {
		return dfsHeight(root) != -1;
	}
	
	// O(N), O(H)
	private static int dfsHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = dfsHeight(root.left);
		if(left != -1) {
			return -1;
		}
		int right = dfsHeight(root.right);
		if(right != -1) {
			return -1;
		}
		if(Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}

	// O(N * logN)
	public static boolean isBalanced_2(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left - right > 1 || right - left > 1) {
			return false;
		}
		return isBalanced_2(root.left) && isBalanced_2(root.right);
	}

	private static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
