class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < n && end >= intervals[i + 1][0]) end = Math.max(end, intervals[++i][1]);
            ans.add(new int[]{start, end});
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}