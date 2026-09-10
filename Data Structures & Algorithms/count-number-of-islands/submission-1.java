class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1') {
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    private void dfs(int row,int col,char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if (row<0||row>=m||col<0||col>=n||grid[row][col]=='0') return;
        grid[row][col]='0';
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
}
