/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node clone = new Node(node.val, new ArrayList<>());
        Node curr = clone;
        dfs(curr, node, new HashMap<>());
        return clone;
    }

    public void dfs(Node curr, Node node, Map<Node,Node> seen){
        if(node.neighbors == null || node.neighbors.isEmpty()) return;
        seen.put(node, curr);
        for(Node neighbor: node.neighbors){
            Node neighborClone = new Node(neighbor.val, new ArrayList<>());
            if(seen.containsKey(neighbor)) neighborClone = seen.get(neighbor);
            else dfs(neighborClone, neighbor, seen);
            curr.neighbors.add(neighborClone);
        }
        return;
    }
}