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
        Deque<ListNode> listDeque = new ArrayDeque<>();

        ListNode curr = head.next;
        while (curr != null) {
            listDeque.addLast(curr);
            curr = curr.next;
        }

        curr = head;
        while (!listDeque.isEmpty()) {
            // Take from the back
            curr.next = listDeque.removeLast();
            curr = curr.next;
            
            // Take from the front
            if (!listDeque.isEmpty()) {
                curr.next = listDeque.removeFirst();
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}
