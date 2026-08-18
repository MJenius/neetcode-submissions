class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=nums[0],currmax=0;
        int min=nums[0],currmin=0;
        int total=0;
        for (int num:nums) {
            currmax=Math.max(currmax+num,num);
            currmin=Math.min(currmin+num,num);
            max=Math.max(max,currmax);
            min=Math.min(min,currmin);
            total+=num;
        }
        return max>0 ? Math.max(total-min,max):max;
    }
}