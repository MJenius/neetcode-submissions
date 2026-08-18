class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        if (grid.length==0) return 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]==1) {
                    ans=Math.max(dfs(i,j,grid),ans);
                }
            }
        }
        return ans;
    }
    private int dfs(int row,int col,int[][] grid) {
        if (row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==0) return 0;
        grid[row][col]=0;
        int area=1;
        area+=dfs(row+1,col,grid);
        area+=dfs(row,col+1,grid);
        area+=dfs(row-1,col,grid);
        area+=dfs(row,col-1,grid);
        return area;
    }
}
