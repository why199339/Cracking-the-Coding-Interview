package Tree_and_Graph;

import java.util.ArrayList;

public class IsBST {

	private static int prev = Integer.MIN_VALUE;

	public static void main(String[] args) {

	}

	public static boolean checkBST_better(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val < min || root.val > max) {
			return false;
		}
		if (!checkBST(root.left, min, root.val) || !checkBST(root.right, root.val, max)) {
			return false;
		}
		return true;
	}

	public static boolean checkBST_inorder_better(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!checkBST_inorder_better(root.left)) {
			return false;
		}
		if (root.val <= prev) {
			return false;
		}
		prev = root.val;
		if (!checkBST_inorder_better(root.right)) {
			return false;
		}
		return true;
	}

	public static boolean checkBST_inorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		copyBST(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static void copyBST(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		copyBST(root.left, list);
		list.add(root.val);
		copyBST(root.right, list);
	}
}
