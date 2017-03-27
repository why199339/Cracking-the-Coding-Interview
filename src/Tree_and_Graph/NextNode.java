package Tree_and_Graph;

import java.util.LinkedList;

public class NextNode {

	public static void main(String[] args) {

	}

	public static TreeNode nextNode(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode node1 = node;
		if (node1.right != null) {
			node1 = node1.right;
			while (node1.left != null) {
				node1 = node1.left;
			}
			return node1;
		} else if (node.parent != null) {
			if (node.parent.left == node) {
				return node.parent;
			} else {
				TreeNode parent = node.parent;
				TreeNode current = node;
				while (parent != null && parent.right == current) {
					current = parent;
					parent = current.parent;
				}
				return parent;
			}
		}
		return null;
	}
}
