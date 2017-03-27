package Tree_and_Graph;

import java.util.ArrayList;

public class LowestCommonAncestor {

	public static void main(String[] args) {

	}

	public static TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		ArrayList<TreeNode> list1 = new ArrayList<>();
		ArrayList<TreeNode> list2 = new ArrayList<>();
		getNodePath(root, p, list1);
		getNodePath(root, q, list2);
		return getCommonAncestor(list1, list2);
	}

	private static TreeNode getCommonAncestor(ArrayList<TreeNode> list1, ArrayList<TreeNode> list2) {
		int index1 = 0;
		int index2 = 0;
		while (index1 != list1.size() && index2 != list2.size()) {
			if (list1.get(index1) == list2.get(index2)) {
				return list1.get(index1);
			}
			index1++;
			index2++;
		}
		return null;
	}

	private static boolean getNodePath(TreeNode root, TreeNode p, ArrayList<TreeNode> list) {
		if (root == p) {
			list.add(root);
			return true;
		}
		list.add(root);
		boolean found = false;
		if (!found && root.left != null) {
			found = getNodePath(root.left, p, list);
		}
		if (!found && root.right != null) {
			found = getNodePath(root.right, p, list);
		}
		if (!found) {
			list.remove(list.size() - 1);
		}
		return found;
	}
}
