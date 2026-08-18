class Solution {
    public int missingNumber(int[] nums) {
        int actualSum=0;
        for(int i=1;i<=nums.length;i++) {
            actualSum+=i;
        }
        int numsSum=0;
        for (int i=0;i<nums.length;i++) {
            numsSum+=nums[i];
        }
        return (actualSum-numsSum);
    }
}