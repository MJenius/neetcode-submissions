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
    private int[] dfs(TreeNode root) {
        if (root==null) return new int[]{1,0};
        int[] l=dfs(root.left);
        int[] r=dfs(root.right);
        boolean balanced=(l[0]==1 && r[0]==1)&&(Math.abs(l[1]-r[1])<=1);
        int height=1+Math.max(l[1],r[1]);
        return new int[]{balanced ? 1:0,height};
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0]==1;
    }
}
