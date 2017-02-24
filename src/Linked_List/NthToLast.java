package Linked_List;

public class NthToLast {

	public static void main(String[] args) {

	}

	public static ListNode nthToList(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
