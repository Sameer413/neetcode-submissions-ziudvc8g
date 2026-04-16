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
        if(head == null) return head;

        Node current = head;
        while (current != null) {
            Node node = new Node(current.val);
            node.next = current.next;
            current.next = node;
            current = node.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while(current != null){
            Node copy = current.next;

            copyCurr.next = copy;
            current.next = copy.next;
            
            current = current.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}
