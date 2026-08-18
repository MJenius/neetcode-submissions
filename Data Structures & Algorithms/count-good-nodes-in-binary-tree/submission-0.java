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
        return count(root,Integer.MIN_VALUE);
    }
    private int count(TreeNode node,int currmax) {
        if (node==null) return 0;
        int c=0;
        if (node.val>=currmax) {
            currmax=node.val;
            c++;
        }
        c+=count(node.left,currmax);
        c+=count(node.right,currmax);
        return c;
    }
}