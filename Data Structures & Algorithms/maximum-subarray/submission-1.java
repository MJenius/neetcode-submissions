class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0],curr=nums[0];
        for (int i=1;i<nums.length;i++) {
            curr= curr+nums[i]>nums[i] ? curr+nums[i]:nums[i];
            max=Math.max(curr,max);
        }
        return max;
    }
}
