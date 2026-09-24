class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;
        for (int w:weights) {
            l=Math.max(l,w);
            r+=w;
        }
        while (l<r) {
            int mid=(l+r)/2;
            int need=1,currWeight=0;
            for (int w:weights) {
                if (currWeight+w>mid) {
                    need++;
                    currWeight=0;
                }
                currWeight+=w;
            }
            if (need>days) l=mid+1;
            else r=mid;
        }
        return l;
    }
}