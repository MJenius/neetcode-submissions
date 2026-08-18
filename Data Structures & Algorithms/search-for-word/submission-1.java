class Solution {
    public char[][] board;
    public int rows;
    public int cols;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        rows=board.length;
        cols=board[0].length;
        for (int r=0;r<rows;r++) {
            for (int c=0;c<cols;c++) if (backtrack(r,c,word,0)) return true;
        }
        return false;
    }
    private boolean backtrack(int r,int c,String word,int idx) {
        if (idx>=word.length()) return true;
        if (r<0||c<0||r>=rows||c>=cols||board[r][c]!=word.charAt(idx)) return false;
        board[r][c]='#';
        int[] rowOffset={0,1,0,-1};
        int[] colOffset={1,0,-1,0};
        boolean ans=false;
        for (int i=0;i<4;i++) {
            ans=backtrack(r+rowOffset[i],c+colOffset[i],word,idx+1);
            if (ans==true) break;
        }
        board[r][c]=word.charAt(idx);
        return ans;
    }
}
