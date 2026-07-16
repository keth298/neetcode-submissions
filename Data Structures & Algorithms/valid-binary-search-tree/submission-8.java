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
    public boolean isValidBST(TreeNode root) {
        Queue<Pair<TreeNode,int[]>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));
        while(!queue.isEmpty()){
            Pair<TreeNode,int[]> pair = queue.remove();
            TreeNode node = pair.getKey();
            int min = pair.getValue()[0];
            int max = pair.getValue()[1];
            if(node.left != null){
                if(node.left.val <= min || node.left.val >= node.val) return false;
                int newMax = node.val;
                queue.add(new Pair<>(node.left,new int[]{min,newMax}));
            }
            if(node.right != null){
                if(node.right.val >= max || node.right.val <= node.val) return false;
                int newMin = node.val;
                queue.add(new Pair<>(node.right,new int[]{newMin,max}));
            }
        }
        return true;
    }
}
