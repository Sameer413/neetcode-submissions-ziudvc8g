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
        if (head == null || head.next == null)
            return;

        ListNode fh = head;
        ListNode mid = getMid(head);

        ListNode sh = reverseList(mid);

         while(fh != null && sh != null){
            ListNode temp = fh.next;
            fh.next = sh;
            fh = temp;

            temp = sh.next;
            sh.next = fh;
            sh = temp;
        }

        if(fh != null){
            fh.next = null;
        }
    }

    public ListNode getMid(ListNode node){
        ListNode s = node;
        ListNode f = node;

        while(f != null && f.next!= null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;

            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }
}
