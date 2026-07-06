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
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int idxToRemove = len - n;
        ListNode prev = null;
        curr = head;

        for (int i = 0; i < idxToRemove; i++) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}
