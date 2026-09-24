class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count=new int[k];
        count[0]=1;
        int sum=0,ans=0,n=nums.length;
        for (int i=0;i<n;i++) {
            sum+=nums[i];
            int rem=((sum%k)+k)%k;
            ans+=count[rem];
            count[rem]++;
        }
        return ans;
    }
}