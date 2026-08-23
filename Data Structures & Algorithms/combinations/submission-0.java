class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        generate(1,n,k,new ArrayList<>(),ans);
        return ans;
    }
    private void generate(int i,int n,int k,List<Integer> curr,List<List<Integer>> ans) {
        if (curr.size()==k) ans.add(new ArrayList<>(curr));
        for (int idx=i;idx<=n;idx++) {
            curr.add(idx);
            generate(idx+1,n,k,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}