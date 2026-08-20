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
    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
        ans=new ArrayList<>();
        postOrder(root);
        return ans;
    }
    private void postOrder(TreeNode node) {
        if (node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        ans.add(node.val);
    }
}