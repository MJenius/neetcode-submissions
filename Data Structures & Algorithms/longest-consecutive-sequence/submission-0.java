class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet=new HashSet<>();
        for (int num:nums) numsSet.add(num);
        int max=0,currmax=0;
        for (int num:numsSet) {
            if (!numsSet.contains(num-1)) {
                currmax=1;
                while (numsSet.contains(num+currmax)) currmax++;
            }
            max=Math.max(max,currmax);
        }
        return max;
    }
}
