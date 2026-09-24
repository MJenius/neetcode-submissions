class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0,r=0;
        for (int num:nums) {
            l=Math.max(l,num);
            r+=num;
        }
        while (l<r) {
            int mid=l+(r-l)/2;
            if (canSplit(mid,nums,k)) r=mid;
            else l=mid+1;
        }
        return l;
    }
    private boolean canSplit(int maxSum,int[] nums,int k) {
        int subarrays=1,curr=0;
        for (int num:nums) {
            if (curr+num>maxSum) {
                subarrays++;
                curr=num;
                if (subarrays>k) return false;
            }
            else curr+=num;
        }
        return true;
    }
}