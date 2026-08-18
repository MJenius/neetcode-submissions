/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size()==0) return 0;
        int[] start=new int[intervals.size()];
        int[] end=new int[intervals.size()];
        for (int i=0;i<intervals.size();i++) {
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int ans=0,startptr=0,endptr=0;
        while (startptr<start.length) {
            if (start[startptr]>=end[endptr]) {
                ans--;
                endptr++;
            }
            ans++;
            startptr++;
        }
        return ans;
    }
}
