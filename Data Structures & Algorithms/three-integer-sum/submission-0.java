class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>0) break;
            if (i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1,r=nums.length-1;
            while (l<r && nums[l]==nums[l+1]) l++;
            while (l<r && nums[r]==nums[r-1]) r--;
            while (l<r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (nums[l]+nums[r]<-nums[i]) l++;
                else r--;
            }
        }
        return ans;
    }
}
