class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights.length==0||heights[0].length==0) return ans;
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacificReachable=new boolean[rows][cols];
        boolean[][] atlanticReachable=new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            dfs(i,0,pacificReachable,heights);
            dfs(i,cols-1,atlanticReachable,heights);
        }
        for (int j=0;j<cols;j++) {
            dfs(0,j,pacificReachable,heights);
            dfs(rows-1,j,atlanticReachable,heights);
        }
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> arr=new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    ans.add(arr);
                }
            }
        }
        return ans;
    }
    private void dfs(int row,int col,boolean[][] reachable,int[][] heights) {
        reachable[row][col]=true;
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for (int[] dir:dirs) {
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if (newRow<0||newCol<0||newRow>=heights.length||newCol>=heights[0].length||reachable[newRow][newCol]) continue;
            if (heights[newRow][newCol]>=heights[row][col]) dfs(newRow,newCol,reachable,heights);
        }
    }
}
