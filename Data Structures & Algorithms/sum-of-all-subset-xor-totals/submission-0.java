class Solution {
    public int subsetXORSum(int[] nums) {
        numArr=nums;
        return dfs(0,0);
    }
    int[] numArr;
    private int dfs(int idx,int total) {
        if (idx==numArr.length) return total;
        return dfs(idx+1,total^numArr[idx]) + dfs(idx+1,total);
    }
}