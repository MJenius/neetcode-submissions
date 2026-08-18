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
    int preorderIndex;
    Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        inOrderIndexMap=new HashMap<>();
        for (int i=0;i<inorder.length;i++) inOrderIndexMap.put(inorder[i],i);
        return arrayToTree(preorder,0,preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder,int l,int r) {
        if (l>r) return null;
        int val=preorder[preorderIndex];
        preorderIndex++;
        TreeNode root=new TreeNode(val);
        root.left=arrayToTree(preorder,l,inOrderIndexMap.get(val)-1);
        root.right=arrayToTree(preorder,inOrderIndexMap.get(val)+1,r);
        return root;
    }
}