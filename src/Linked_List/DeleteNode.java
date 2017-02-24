package Linked_List;

public class DeleteNode {

	public static void main(String[] args) {

	}

	public static ListNode deleteNode(ListNode head, ListNode node) {
		if(node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		} else if (node == head) {
			head = null;
			node = null;
		} else {
			ListNode n = node;
			while(n.next != node) {
				n = n.next;
			}
			n.next = null;
		}
		return head;
	}
}
