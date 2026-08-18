class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int l=0,r=1;
        while (l<prices.length && r<prices.length) {
            if (prices[l]>prices[r]) {
                l=r;
            }
            else {
                max=Math.max(max,prices[r]-prices[l]);
                r++;
            }
        }
        return max;
    }
}
