package Linked_List;

public class FindBeginning {

	public static void main(String[] args) {

	}

	public static ListNode findBeginning(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != fast && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
