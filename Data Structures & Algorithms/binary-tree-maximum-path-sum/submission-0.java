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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    private int maxGain(TreeNode node) {
        if (node==null) return 0;
        int lGain=Math.max(maxGain(node.left),0);
        int rGain=Math.max(maxGain(node.right),0);
        int newPath=node.val+lGain+rGain;
        max=Math.max(max,newPath);
        return node.val+Math.max(lGain,rGain);
    }
}