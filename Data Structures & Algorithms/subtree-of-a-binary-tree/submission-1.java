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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(!isSameTree(curr,subRoot)){
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
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
