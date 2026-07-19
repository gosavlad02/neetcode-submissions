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
        // naive: materialize both numbers, return addition

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        int carryOver = 0;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carryOver;
            carryOver = 0;
            if (sum > 9) {
                carryOver = 1;
                sum -= 10;
            }
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int sum = curr1.val + carryOver;
            carryOver = 0;
            if (sum > 9) {
                carryOver = 1;
                sum -= 10;
            }
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int sum = curr2.val + carryOver;
            carryOver = 0;
            if (sum > 9) {
                carryOver = 1;
                sum -= 10;
            }
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;
            curr2 = curr2.next;
        }
        if (carryOver > 0) {
            ListNode carryNode = new ListNode(carryOver);
            head.next = carryNode;
            head = head.next;
        }
        return dummy.next;
    }
}
