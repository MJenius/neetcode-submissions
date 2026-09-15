class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for (int p:piles) max=Math.max(max,p);
        int l=1;
        while (l<max) {
            int hrs=0,mid=(l+max)/2;
            for (int p:piles) hrs+=Math.ceil((double)p/mid);
            if (hrs>h) l=mid+1;
            else max=mid;
        }
        return l;
    }
}
