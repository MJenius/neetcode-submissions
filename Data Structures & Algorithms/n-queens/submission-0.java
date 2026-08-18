class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board=new char[n][n];
        for (int i=0;i<n;i++) for (int j=0;j<n;j++) board[i][j]='.';
        backtrack(board,ans,0);
        return ans;
    }
    private void backtrack(char[][] board,List<List<String>> ans,int col) {
        if (col==board.length) {
            ans.add(construct(board));
            return;
        }
        for (int i=0;i<board.length;i++) {
            if(isValid(board,i,col)) {
                board[i][col]='Q';
                backtrack(board,ans,col+1);
                board[i][col]='.';
            }
        }
    }
    private List<String> construct(char[][] board) {
        List<String> ans=new ArrayList<>();
        for (int i=0;i<board.length;i++) {
            ans.add(new String(board[i]));
        }
        return ans;
    }
    private boolean isValid(char[][] board,int row,int col) {
        for (int i=0;i<col;i++) if (board[row][i]=='Q') return false;
        for (int i=row,j=col;i>=0 && j>=0;i--,j--) if (board[i][j]=='Q') return false;
        for (int i=row,j=col;i<board.length && j>=0;i++,j--) if (board[i][j]=='Q') return false;
        return true;
    }
}
