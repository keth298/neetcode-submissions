class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        int split = 0;
        while (inorder[split] != preorder[0]) split++;
        
        int[] leftIn = Arrays.copyOfRange(inorder, 0, split);
        int[] rightIn = Arrays.copyOfRange(inorder, split + 1, inorder.length);
        int[] leftPre = Arrays.copyOfRange(preorder, 1, split + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, split + 1, preorder.length);

        return new TreeNode(preorder[0], buildTree(leftPre, leftIn), buildTree(rightPre, rightIn));
    }
}