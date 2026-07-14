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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return subRoot == null;

        Queue<Pair<TreeNode,TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, subRoot));
        while(!queue.isEmpty()){
            Pair<TreeNode,TreeNode> pair = queue.remove();
            if(!isSameTree(pair.getKey(),pair.getValue())){
                if(pair.getKey().left != null) queue.add(new Pair<>(pair.getKey().left, subRoot));
                if(pair.getKey().right != null) queue.add(new Pair<>(pair.getKey().right, subRoot));
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair<TreeNode,TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(p, q));
        while(!queue.isEmpty()){
            Pair<TreeNode, TreeNode> pair = queue.remove();
            if(pair.getKey() != null && pair.getValue() != null){
                if(pair.getKey().val != pair.getValue().val) return false;
                queue.add(new Pair<>(pair.getKey().left,pair.getValue().left));
                queue.add(new Pair<>(pair.getKey().right,pair.getValue().right));
            } else {
                if(pair.getKey() != null || pair.getValue() != null) return false;
            }

        }
        return true;
    }
}
