package Linked_List;

public class Partition {

	public static void main(String[] args) {

	}

	public static ListNode partition_1(ListNode head, int x) {
		ListNode before = new ListNode(0);
		ListNode after = new ListNode(0);
		ListNode head_before = before;
		ListNode head_after = after;
		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				before.next = new ListNode(node.val);
				before = before.next;
			} else {
				after.next = new ListNode(node.val);
				after = after.next;
			}
		}
		before.next = head_after.next;
		return head_before.next;
	}

	public static ListNode partition_2(ListNode head, int x) {
		ListNode before_start = null;
		ListNode after_start = null;
		while(head != null) {
			ListNode next = head.next;
			if(head.val < x) {
				head.next = before_start;
				before_start = head;
			} else {
				head.next = after_start;
				after_start = head;
			}
			head = next;
		}
		if(before_start == null) {
			return after_start;
		}
		ListNode node = before_start;
		while(node.next != null) {
			node = node.next;
		}
		node.next = after_start;
		return before_start;
	}
}
