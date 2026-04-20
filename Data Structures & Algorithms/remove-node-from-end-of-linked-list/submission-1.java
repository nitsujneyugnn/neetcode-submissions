/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;

        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode front = head;

        while (curr != null) {
            curr = curr.next;
            prev = front;
            front = front.next;
        }

        if (prev == null) {
            return head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }
}
