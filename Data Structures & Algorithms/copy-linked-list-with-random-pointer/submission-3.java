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
        // Elegant solution with computeIfAbsent for 1 loop pass
        Map<Node, Node> nodeMap = new HashMap<>(); // original, copy

        Node curr = head;
        while (curr != null) {
            Node currCopy = nodeMap.computeIfAbsent(curr, key -> new Node(key.val));
            currCopy.next = curr.next == null ? null : nodeMap.computeIfAbsent(curr.next, key -> new Node(key.val));
            currCopy.random = curr.random == null ? null : nodeMap.computeIfAbsent(curr.random, key -> new Node(key.val));

            curr = curr.next;
        }
        return nodeMap.get(head);
    }
}
