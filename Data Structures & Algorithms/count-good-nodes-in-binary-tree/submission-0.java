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
            Pair<TreeNode, Integer> pair = queue.remove();
            if(pair.getKey().val >= pair.getValue()) good++;
            if(pair.getKey().left != null) queue.add(new Pair<>(pair.getKey().left, Math.max(pair.getValue(),pair.getKey().left.val)));
            if(pair.getKey().right != null) queue.add(new Pair<>(pair.getKey().right, Math.max(pair.getValue(),pair.getKey().right.val)));
        }
        return good;
    }
}
