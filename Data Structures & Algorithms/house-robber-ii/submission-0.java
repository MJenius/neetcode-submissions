class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        return Math.max(robber(nums,0,n-2),robber(nums,1,n-1));
    }

    private int robber(int[] nums,int l,int r) {
        int prev=0,curr=0;
        for (int i=l;l<=r;l++) {
            int temp=Math.max(prev+nums[l],curr);
            prev=curr;
            curr=temp;
        }
        return curr;
    }
}