package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Iterative_Traversal {

	public static void main(String[] args) {

	}

	public static List<Integer> MorrispreOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		TreeNode cur1 = root;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					list.add(cur1.val);
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				list.add(cur1.val);
			}
			cur1 = cur1.right;
		}
		return list;
	}

	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.add(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				list.add(root.val);
				if (root.right != null) {
					stack.push(root.right);
				}
				if (root.left != null) {
					stack.push(root.left);
				}
			}
		}
		return list;
	}

	public static List<Integer> MorrisinOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		TreeNode cur1 = root;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			list.add(cur1.val);
			cur1 = cur1.right;
		}
		return list;
	}

	public static List<Integer> inOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode node = stack.pop();
				list.add(node.val);
				root = node.right;
			}
		}
		return list;
	}

	public static void MorrispostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode cur1 = root;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					printEdge(cur1.left);
					cur2.right = null;
				}
			}
			cur1 = cur1.right;
		}
		printEdge(root);
	}

	private static void printEdge(TreeNode head) {
		TreeNode tail = reverseEdge(head);
		TreeNode cur = tail;
		while (cur != null) {
			System.out.println(cur.val + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	private static TreeNode reverseEdge(TreeNode head) {
		TreeNode reverseHead = null;
		TreeNode prev = null;
		TreeNode cur = head;
		while (cur != null) {
			TreeNode next = cur.right;
			if (next == null) {
				reverseHead = cur;
			}
			cur.right = prev;
			prev = cur;
			cur = next;
		}
		return reverseHead;
	}

	public static List<Integer> postOrder_1(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				list.addFirst(root.val);
				root = root.right;
			} else {
				TreeNode node = stack.pop();
				root = node.left;
			}
		}
		return list;
	}

	public static List<Integer> postOrder_2(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		if (root != null) {
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			stack1.push(root);
			while (!stack1.isEmpty()) {
				root = stack1.pop();
				list.add(root.val);
				if (root.left != null) {
					stack1.push(root.left);
				}
				if (root.right != null) {
					stack2.push(root.right);
				}
			}
			while (!stack2.isEmpty()) {
				list.add(stack2.pop().val);
			}
		}
		return list;
	}

	public static List<Integer> postOrder_3(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			TreeNode node = null;
			while (!stack.isEmpty()) {
				node = stack.peek();
				if (node.left != null && root != node.left && root != root.right) {
					stack.push(node.left);
				} else if (node.right != null && root != node.right) {
					stack.push(node.right);
				} else {
					list.add(stack.pop().val);
					root = node;
				}
			}
		}
		return list;
	}
}
