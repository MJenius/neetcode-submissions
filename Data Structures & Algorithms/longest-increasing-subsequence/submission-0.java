class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans=1;
        for (int i=1;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i]>nums[j]) lis[i]=Math.max(lis[i],1+lis[j]);
                ans=Math.max(ans,lis[i]);
            }
        }
        return ans;
    }
}
