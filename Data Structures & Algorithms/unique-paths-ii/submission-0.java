class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
        obstacleGrid[m-1][n-1]=1;
        for (int r=m-1;r>=0;r--) {
            for (int c=n-1;c>=0;c--) {
                if (r==m-1 && c==n-1) continue;
                if (obstacleGrid[r][c]==1) obstacleGrid[r][c]=0;
                else {
                    int down=(r<m-1) ? obstacleGrid[r+1][c]:0;
                    int right=(c<n-1) ? obstacleGrid[r][c+1]:0;
                    obstacleGrid[r][c]=down+right;
                }
            }
        }
        return obstacleGrid[0][0];
    }
}