class Solution {
    public int jump(int[] nums) {
        int jumps=0,currmax=0,currend=0;
        for (int i=0;i<nums.length-1;i++) {
            currmax=Math.max(currmax,i+nums[i]);
            if (i==currend) {
                jumps++;
                currend=currmax;
            }
        }
        return jumps;
    }
}
