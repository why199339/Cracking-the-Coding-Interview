package Tree_and_Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class CreateLevelLinkedList {

	public static void main(String[] args) {

	}

	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList_DFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevel(root, lists, 0);
		return lists;
	}

	private void createLevel(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevel(root.left, lists, level + 1);
		createLevel(root.right, lists, level + 1);
	}

	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList_BFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		while (!current.isEmpty()) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
}
