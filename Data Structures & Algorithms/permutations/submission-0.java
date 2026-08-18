class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(ans,nums,new ArrayList<>(),used);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,int[] nums,List<Integer> curr,boolean[] used) {
        if (curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!used[i]) {
                curr.add(nums[i]);
                used[i]=true;
                backtrack(ans,nums,curr,used);
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}
