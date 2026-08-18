class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int l=0,r=n*n-1;
        while (l<r) {
            int mid=l+(r-l)/2;
            if (canSwim(grid,mid)) r=mid;
            else l=mid+1;
        }
        return l;
    }
    private boolean canSwim(int[][] grid,int t) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        return dfs(grid,visited,0,0,t);
    }
    private boolean dfs(int[][] grid,boolean[][] visited,int i,int j,int t) {
        int n=grid.length;
        if (i<0||j<0||i>=n||j>=n||visited[i][j]||grid[i][j]>t) return false;
        if (i==n-1 && j==n-1) return true;
        visited[i][j]=true;
        return dfs(grid,visited,i+1,j,t)||dfs(grid,visited,i-1,j,t)||dfs(grid,visited,i,j+1,t)||dfs(grid,visited,i,j-1,t);
    }
}
