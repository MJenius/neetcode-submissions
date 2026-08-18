class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int ans=0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j]=='1') {
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    private void dfs(int row,int col,char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if (row<0||row>=rows||col<0||col>=cols||grid[row][col]=='0') return;
        grid[row][col]='0';
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] dir:dirs) dfs(row+dir[0],col+dir[1],grid);
    }
}
