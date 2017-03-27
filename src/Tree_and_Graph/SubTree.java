package Tree_and_Graph;

public class SubTree {

	public static void main(String[] args) {

	}

	public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		while (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = check(root1, root2);
			}
			if (!result) {
				result = check(root1.left, root2);
			}
			if (!result) {
				result = check(root1.right, root2);
			}
		}
		return result;
	}

	private static boolean check(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return check(root1.left, root2.left) && check(root1.right, root2.right);
	}
}
