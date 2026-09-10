class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumCounts=new HashMap<>();
        int sum=0,ans=0;
        prefixSumCounts.put(0,1);
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if (prefixSumCounts.containsKey(sum-k)) ans+=prefixSumCounts.get(sum-k);
            prefixSumCounts.put(sum,prefixSumCounts.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}