class Solution {
    private List<String> ans=new ArrayList<>();
    char[][] fullboard=null;
    class TrieNode {
        HashMap<Character,TrieNode> children=new HashMap<>();
        String word=null;
    }
    public void backtrack(int row,int col,TrieNode parent) {
        char c=fullboard[row][col];
        TrieNode curr=parent.children.get(c);
        if (curr == null) return;
        if (curr.word!=null) {
            ans.add(curr.word);
            curr.word=null;
        }
        fullboard[row][col]='#';
        int[] rowOffset={-1,0,1,0};
        int[] colOffset={0,1,0,-1};
        for (int i=0;i<4;i++) {
            int newRow=row+rowOffset[i];
            int newCol=col+colOffset[i];
            if (newRow<0||newRow>=fullboard.length||newCol<0||newCol>=fullboard[0].length) continue;
            if (fullboard[newRow][newCol] != '#') backtrack(newRow,newCol,curr);
        }
        fullboard[row][col]=c;
        if (parent.children.isEmpty()) parent.children.remove(c);

    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for (String word:words) {
            TrieNode node=root;
            for (char c:word.toCharArray()) {
                node.children.putIfAbsent(c,new TrieNode());
                node=node.children.get(c);
            }
            node.word=word;
        }
        this.fullboard=board;
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (root.children.containsKey(board[i][j])) backtrack(i,j,root);
            }
        }
        return ans;
    }
}