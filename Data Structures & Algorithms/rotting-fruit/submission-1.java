class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length,ans=0,fresh=0;
        if (m==0||n==0) return -1;
        Queue<int[]> rottenQueue=new LinkedList<>();
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) fresh++;
                else if (grid[i][j]==2) rottenQueue.offer(new int[]{i,j});
            }
        }
        if (fresh==0) return 0;
        while (!rottenQueue.isEmpty()) {
            int size=rottenQueue.size();
            for (int i=0;i<size;i++) {
                int[] rotten=rottenQueue.poll();
                int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
                for (int[] dir:dirs) {
                    int x=rotten[0]+dir[0];
                    int y=rotten[1]+dir[1];
                    if (x>=0 && y>=0 && x<m && y<n && grid[x][y]==1) {
                        grid[x][y]=2;
                        fresh--;
                        rottenQueue.offer(new int[]{x,y});
                    }
                }
            }
            ans++;
        }
        return fresh==0 ? ans-1:-1;
    }
}
