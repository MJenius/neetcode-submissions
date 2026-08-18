class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        backtrack(ans,nums,target,0,combination);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,int[] nums,int target,int index,List<Integer> combination) {
        if (target==0) ans.add(new ArrayList<>(combination));
        if (target<0) return;
        for (int i=index;i<nums.length;i++) {
            combination.add(nums[i]);
            backtrack(ans,nums,target-nums[i],i,combination);
            combination.remove(combination.size()-1);
        }
    }
}
