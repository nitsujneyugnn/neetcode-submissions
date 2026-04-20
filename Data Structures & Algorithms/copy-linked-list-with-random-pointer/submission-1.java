/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        ArrayList<Node> arr = new ArrayList<>();

        ArrayList<Node> original = new ArrayList<>();

        Node result = new Node(head.val);
        Node curr = head.next;
        Node rCurr = result;

        arr.add(result);
        original.add(head);

        while (curr != null) {
            original.add(curr);
            rCurr.next = new Node(curr.val);
            arr.add(rCurr.next);
            rCurr = rCurr.next;
            curr = curr.next;
        }

        curr = head;
        rCurr = result;
        while (curr != null) {
            if (curr.random == null) {
                rCurr.random = null;
            } else {
                int index = original.indexOf(curr.random);
                arr.get(arr.indexOf(rCurr)).random = arr.get(index);
            }
            curr = curr.next;
            rCurr = rCurr.next;
        }


        return result;
    }
}
