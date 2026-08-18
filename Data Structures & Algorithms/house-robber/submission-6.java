class Solution {
    public int rob(int[] nums) {
        int rob1=0,rob2=0,ans=0;
        for (int i=0;i<nums.length;i++) {
            ans=Math.max(ans,rob1+nums[i]);
            rob1=rob2;
            rob2=ans;
        }
        return ans;
    }
}
