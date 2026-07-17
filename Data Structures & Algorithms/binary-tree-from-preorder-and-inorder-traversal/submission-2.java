class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(0);
        TreeNode curr = head;
        int i = 0;
        int j = 0;
        int n = preorder.length;
        while(i < n && j < n){
            curr.right = new TreeNode(preorder[i], null, curr.right);
            curr = curr.right;
            i++;
            while(i < n && curr.val != inorder[j]){
                curr.left = new TreeNode(preorder[i], null, curr);
                curr = curr.left;
                i++;
            }
            j++;
            while(curr.right != null && j < n && inorder[j] == curr.right.val){
                TreeNode parent = curr.right;
                curr.right = null;
                curr = parent;
                j++;
            }
        }
        return head.right;
    }
}