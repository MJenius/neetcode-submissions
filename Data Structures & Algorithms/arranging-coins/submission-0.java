class Solution {
    public int arrangeCoins(int n) {
        int l=1;
        int r=n;
        int ans=0;
        while (l<=r) {
            int mid=l+(r-l)/2;
            long coins=(long)(mid)*(mid+1)/2;
            if (coins>n) r=mid-1;
            else {
                l=mid+1;
                ans=Math.max(mid,ans);
            }
        }
        return ans;
    }
}