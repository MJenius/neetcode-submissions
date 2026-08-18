class Solution {
    public int findMin(int[] nums) {
        int ans=nums[0];
        int l=0,r=nums.length-1;
        while (l<=r) {
            if (nums[l]<nums[r]) {
                ans=Math.min(ans,nums[l]);
                break;
            }
            int m=(l+r)/2;
            ans=Math.min(nums[m],ans);
            if (nums[m]>=nums[l]) l=m+1;
            else r=m-1;
        }
        return ans;
    }
}
