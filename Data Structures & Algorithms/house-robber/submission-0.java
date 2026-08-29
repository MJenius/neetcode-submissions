class Solution {
    public int rob(int[] nums) {
        int max=0;
        for (int i=2;i<nums.length;i++) {
            nums[i]=nums[i-2]+nums[i];
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
