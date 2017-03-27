package Linked_List;

import java.util.Stack;

public class IsPalindrome {

	public static void main(String[] args) {

	}

	public static boolean isPanlidrome_Iterative(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			int top = stack.pop();
			if (slow.val != top) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static boolean isPanlidrome_Recursive(ListNode head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		Result r = isPanlidrome_Recursive_core(head, len);
		return r.result;
	}

	private static Result isPanlidrome_Recursive_core(ListNode head, int len) {
		if(head == null || len == 0) {
			return new Result(null, true);
		}
		if(len == 1) {
			return new Result(head.next, true);
		}
		if(len == 2) {
			return new Result(head.next.next, head.val == head.next.val);
		}
		Result res = isPanlidrome_Recursive_core(head.next, len - 2);
		if(!res.result || res.node == null) {
			return res;
		} else {
			res.result = (head.val == res.node.val);
			res.node = res.node.next;
			return res;
		}
	}
}

class Result {
	ListNode node;
	boolean result;
	public Result(ListNode node, boolean result) {
		super();
		this.node = node;
		this.result = result;
	}
	
}
