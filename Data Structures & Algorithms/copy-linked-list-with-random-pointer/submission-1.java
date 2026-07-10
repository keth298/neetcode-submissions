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
        Node dummy = new Node(0);
        Node copy = dummy;
        Node curr = head;

        Map<Integer, Node> copies = new HashMap<>();
        Map<Node, Integer> indices = new HashMap<>();
        int index = 0;
        while(curr != null){
            Node temp = new Node(curr.val);
            copy.next = temp;
            copy = copy.next;
            copies.put(index,copy);
            indices.put(curr, index);
            curr = curr.next;
            index++;
        }

        curr = head;
        Map<Node, Integer> randoms = new HashMap<>();
        while(curr != null){
            randoms.put(curr, indices.get(curr.random));
            curr= curr.next;
        }

        curr = head;
        copy = dummy.next;
        while(curr != null){
            copy.random = copies.get(randoms.get(curr));
            copy = copy.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
