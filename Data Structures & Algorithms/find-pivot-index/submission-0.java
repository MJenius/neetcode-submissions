class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0,lSum=0;
        for (int num:nums) sum+=num;
        for (int i=0;i<nums.length;i++) {
            int Rsum=sum-lSum-nums[i];
            if (lSum==Rsum) return i;
            lSum+=nums[i];
        }
        return -1;
    }
}