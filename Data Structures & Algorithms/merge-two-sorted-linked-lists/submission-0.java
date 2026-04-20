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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode curr = list1;
        ListNode curr2 = list2;
        
        // null cases
        if (curr == null || curr2 == null) {
            if (curr != null && curr2 == null) {
                return curr;
            } else if (curr2 != null && curr == null) {
                return curr2;
            } else {
                return null;
            }
        }
        
        // first case
        if (curr.val < curr2.val) {
            res = curr;
            curr = curr.next;
        } else {
            res = curr2;
            curr2 = curr2.next;
        }
        ListNode resIt = res;
        // middle case
        while (curr != null && curr2 != null) {
            if (curr.val < curr2.val) {
                resIt.next = curr;
                curr = curr.next;
            } else {
                resIt.next = curr2;
                curr2 = curr2.next;
            }
            resIt = resIt.next;
        }

        // end case
        if (curr != null) {
            resIt.next = curr;
        } else {
            resIt.next = curr2;
        }

        return res;
    }
}