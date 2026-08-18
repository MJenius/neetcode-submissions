class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int visited=101;
        List<Integer> ans=new ArrayList<>();
        ans.add(matrix[0][0]);
        matrix[0][0]=visited;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        int currdir=0,changedir=0,row=0,col=0;
        while (changedir<2) {
            while (row+dirs[currdir][0]>=0 &&
            col+dirs[currdir][1]>=0 &&
            row+dirs[currdir][0]<m &&
            col+dirs[currdir][1]<n &&
            matrix[row+dirs[currdir][0]][col+dirs[currdir][1]]!=visited) {
                row+=dirs[currdir][0];
                col+=dirs[currdir][1];
                changedir=0;
                ans.add(matrix[row][col]);
                matrix[row][col]=visited;
            }
            currdir=(currdir+1)%4;
            changedir++;
        }
        return ans;
    }
}
