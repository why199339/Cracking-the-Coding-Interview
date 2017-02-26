package Linked_List;

public class AddLists {

	public static void main(String[] args) {

	}

	public static ListNode addLists(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		ListNode p1 = head1;
		ListNode p2 = head2;
		ListNode cur = head;
		int carry = 0;
		int sum = 0;
		while (p1 != null || p2 != null) {
			int x = (p1 == null) ? 0 : p1.val;
			int y = (p2 == null) ? 0 : p2.val;
			sum = x + y + carry;
			cur.next = new ListNode(sum / 10);
			cur = cur.next;
			carry = sum % 10;
			if (p1 != null) {
				p1 = p1.next;
			}
			if (p2 != null) {
				p2 = p2.next;
			}
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return head.next;
	}
}
