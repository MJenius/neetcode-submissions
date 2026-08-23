class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    private void generate(int i,int[] nums,List<Integer> curr,List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for (int j=i;j<nums.length;j++) {
            curr.add(nums[j]);
            generate(j+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}
