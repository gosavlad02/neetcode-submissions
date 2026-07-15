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
        // Naive solution with hashmap
        Map<Node, Node> nodeMap = new HashMap<>(); // original, copy

        Node curr = head;
        while (curr != null) {
            Node currCopy = new Node(curr.val);
            nodeMap.put(curr, currCopy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copyNode = nodeMap.get(curr);
            copyNode.next = curr.next == null ? null : nodeMap.get(curr.next); // this is the value, not good
            copyNode.random = curr.random == null ? null : nodeMap.get(curr.random);
            curr = curr.next;
        }
        return nodeMap.get(head);
    }
}
