package Linked_List;

import java.util.HashSet;

public class DeleteDups {

	public static void main(String[] args) {

	}

	public static void deleteDups_hash(ListNode head) {
		if (head == null) {
			return;
		}
		HashSet<ListNode> set = new HashSet<>();
		ListNode node = head;
		while (head != null) {
			if (set.contains(head)) {
				node.next = head.next;
			} else {
				set.add(head);
				head = head.next;
			}
		}
	}

	public static void deleteDups_not_hash(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode node = head;
		while (node != null) {
			ListNode runner = head;
			while (runner.next != null) {
				if (runner.next.val == node.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			node = node.next;
		}
	}
}
