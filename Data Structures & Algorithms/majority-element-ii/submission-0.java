class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> count = new HashMap<>();
        for (int num:nums) {
            count.put(num,count.getOrDefault(num,0)+1);
            if (count.size()>2) {
                Map<Integer,Integer> newcount = new HashMap<>();
                for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
                    if (entry.getValue()>1) newcount.put(entry.getKey(),entry.getValue()-1);
                }
                count=newcount;
            }
        }
        for (int key:count.keySet()) {
            int freq=0;
            for (int num:nums) {
                if (num==key) freq++;
            }
            if (freq>nums.length/3) ans.add(key);
        }
        return ans;
    }
}