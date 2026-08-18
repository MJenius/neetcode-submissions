class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        generate(nums,0,new ArrayList<>(),set);
        return new ArrayList<>(set);
    }
    private void generate(int[] nums, int idx,List<Integer> curr, Set<List<Integer>> set) {
        set.add(new ArrayList<>(curr));
        for (int i=idx;i<nums.length;i++) {
            curr.add(nums[i]);
            generate(nums,i+1,curr,set);
            curr.remove(curr.size()-1);
        }
    }
}
