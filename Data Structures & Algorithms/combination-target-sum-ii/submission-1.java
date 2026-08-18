class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(candidates,ans,new ArrayList<>(),target,0);
        return ans;
    }
    private void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> curr, int target,int start) {
        if (target<0) return;
        if (target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i=start;i<nums.length;i++) {
            if (i>start && nums[i]==nums[i-1]) continue;
            if (nums[i]>target) break;
            curr.add(nums[i]);
            backtrack(nums,ans,curr,target-nums[i],i+1);
            curr.remove(curr.size()-1);
        }
    }
}
