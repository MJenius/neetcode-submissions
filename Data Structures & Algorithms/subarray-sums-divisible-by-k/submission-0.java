class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixRemainders = new HashMap<>();
        prefixRemainders.put(0, 1);
        int sum = 0,ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = ((sum % k) + k) % k;
            ans += prefixRemainders.getOrDefault(rem, 0);
            prefixRemainders.put(rem,prefixRemainders.getOrDefault(rem, 0)+1);
        }
        return ans;
    }
}