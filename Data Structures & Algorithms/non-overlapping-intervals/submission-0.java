class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int prev=0,ans=0;
        for (int i=1;i<intervals.length;i++) {
            if (intervals[prev][1]>intervals[i][0]) {
                if (intervals[prev][1]>intervals[i][1]) prev=i;
                ans++;
            }
            else prev=i;
        }
        return ans;
    }
}
