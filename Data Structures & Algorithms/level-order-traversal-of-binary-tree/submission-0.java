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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        int currLevel = 0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.remove();
            if(pair.getValue() != currLevel){
                res.add(new LinkedList<>());
                currLevel++;
            } 
            res.getLast().add(pair.getKey().val);
            if(pair.getKey().left != null) queue.add(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            if(pair.getKey().right != null) queue.add(new Pair<>(pair.getKey().right, pair.getValue() + 1));
        }
        return res;
    }
}
