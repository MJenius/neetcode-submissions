class Solution {
    public void sortColors(int[] nums) {
        int[] count= new int[3];
        for (int num:nums) count[num]++;
        int k=0;
        while (k<nums.length) {
            if (count[0]>0) {
                nums[k++]=0;
                count[0]--;
            }
            else if (count[1]>0) {
                nums[k++]=1;
                count[1]--;
            }
            else {
                nums[k++]=2;
            }
        }
    }
}