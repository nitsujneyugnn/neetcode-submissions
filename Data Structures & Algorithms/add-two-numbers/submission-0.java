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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        int digit = 1;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null) {
            n1 += c1.val * digit;
            c1 = c1.next;
            digit *= 10;
        }

        digit = 1;

        while (c2 != null) {
            n2 += c2.val * digit;
            c2 = c2.next;
            digit *= 10;
        }

        int total = n1 + n2;
        ListNode res = new ListNode(total % 10);
        total /= 10;
        ListNode rCurr = res;

        while (total != 0) {
            rCurr.next = new ListNode(total % 10);
            rCurr = rCurr.next;
            total /= 10;

        }

        return res;
    }
}
