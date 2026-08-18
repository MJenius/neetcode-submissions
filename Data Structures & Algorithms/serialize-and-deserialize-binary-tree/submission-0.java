/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void recserialize(TreeNode node,StringBuilder sb) {
        if (node==null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        recserialize(node.left,sb);
        recserialize(node.right,sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        recserialize(root,sb);
        return sb.toString();
    }

    private TreeNode recdeserialize(Queue<String> q) {
        String val=q.poll();
        if (val.equals("null")) return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=recdeserialize(q);
        node.right=recdeserialize(q);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
        return recdeserialize(q);   
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));