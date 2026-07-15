/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, root.val));
        int good = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.peek().getKey();
            int maxSoFar = queue.poll().getValue();
            if(node.val >= maxSoFar) good++;
            int newMax = Math.max(maxSoFar, node.val);
            if(node.left != null) queue.add(new Pair<>(node.left, newMax));
            if(node.right != null) queue.add(new Pair<>(node.right, newMax));
        }
        return good;
    }
}
