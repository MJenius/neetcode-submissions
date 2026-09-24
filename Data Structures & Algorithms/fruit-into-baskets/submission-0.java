class Solution {
    public int totalFruit(int[] fruits) {
       Map<Integer,Integer> count=new HashMap<>();
       int l=0,ans=0,total=0;
       for (int r=0;r<fruits.length;r++) {
        count.put(fruits[r],count.getOrDefault(fruits[r], 0)+1);
        total++;
        while (count.size()>2) {
            count.put(fruits[l],count.get(fruits[l])-1);
            total--;
            if (count.get(fruits[l])==0) count.remove(fruits[l]);
            l++;
        }
        ans=Math.max(ans,total);
       }
       return ans;
    }
}