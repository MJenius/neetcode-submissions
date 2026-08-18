class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        Integer[] queryidx=new Integer[n];
        for (int i=0;i<n;i++) queryidx[i]=i;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(queryidx,(a,b)->Integer.compare(queries[a],queries[b]));
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        int intervalIdx=0;
        for (int i=0;i<n;i++) {
            int query=queries[queryidx[i]];
            while (intervalIdx<intervals.length && intervals[intervalIdx][0]<=query) {
                int start=intervals[intervalIdx][0];
                int end=intervals[intervalIdx][1];
                if (end>=query) minHeap.offer(new int[]{start,end});
                intervalIdx++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1]<query) minHeap.poll();
            if (minHeap.isEmpty()) ans[queryidx[i]]=-1;
            else {
                int[] smallestInterval=minHeap.peek();
                ans[queryidx[i]]=smallestInterval[1]-smallestInterval[0]+1;
            }
        }
        return ans;
    }
}
