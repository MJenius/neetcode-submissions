class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] extended=new int[n+2];
        extended[0]=1;
        extended[n+1]=1;
        for (int i=1;i<=n;i++) extended[i]=nums[i-1];
        int[][] dp = new int[n+2][n+2];
        for (int len=1;len<=n;len++) {
            for (int l=1;l<=n-len+1;l++) {
                int r=l+len-1;
                for (int i=l;i<=r;i++) {
                    int coins=extended[l-1]*extended[i]*extended[r+1];
                    coins+=dp[l][i-1]+dp[i+1][r];
                    dp[l][r]=Math.max(dp[l][r],coins);
                }
            }
        }
        return dp[1][n];
    }
}
