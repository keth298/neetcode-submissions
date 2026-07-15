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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        List<Integer> res = new LinkedList<>();
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.remove();
            if(pair.getKey().left != null) queue.add(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            if(pair.getKey().right != null) queue.add(new Pair<>(pair.getKey().right, pair.getValue() + 1));
            
            if((queue.isEmpty()) || (!queue.isEmpty() && queue.peek().getValue() > pair.getValue())) res.add(pair.getKey().val);
        }
        return res;
    }
}
