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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            curr = curr.next;
            size++;
        }

        ListNode rev = head;
        ListNode prev = null;

        for (int i = 0; i < Math.ceil(size / 2.0); i++) {
            prev = rev;
            rev = rev.next;
        }
        // Split list into two halves
        prev.next = null;

        // Reverse second half
        ListNode fol = rev;
        curr = rev;
        prev = null;

        while (curr != null) {
            fol = fol.next;
            curr.next = prev;
            prev = curr;
            curr = fol;
        }

        rev = prev;

        // Weave two lists;

        curr = head;
        while (rev != null) {
            ListNode node = curr.next;
            curr.next = rev;
            curr = curr.next;
            rev = rev.next;
            curr.next = node;
            curr = node;
        }
    }
}
