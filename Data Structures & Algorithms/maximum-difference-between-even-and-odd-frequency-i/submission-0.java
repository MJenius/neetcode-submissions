class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c:s.toCharArray()) map.put(c,map.getOrDefault(c, 0)+1);
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int count:map.values()) {
            min=count%2==0 ? Math.min(count,min):min;
            max=count % 2==1 ? Math.max(count,max):max;
        }
        return max-min;
    }
}