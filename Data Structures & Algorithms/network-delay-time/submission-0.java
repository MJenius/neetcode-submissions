class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for (int[] edge:times) {
            graph.computeIfAbsent(edge[0],s->new ArrayList<>()).add(new int[]{edge[1],edge[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int[] distances=new int[n+1];
        pq.offer(new int[]{k,0});
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[k]=0;
        while (!pq.isEmpty()) {
            int[] curr=pq.poll();
            int currNode=curr[0];
            int currDist=curr[1];
            if (currDist>distances[currNode]) continue;
            if (graph.containsKey(currNode)) {
                for (int[] neighbor:graph.get(currNode)) {
                    int nextNode=neighbor[0];
                    int nextDist=currDist+neighbor[1];
                    if (nextDist<distances[nextNode]) {
                        distances[nextNode]=nextDist;
                        pq.offer(new int[]{nextNode,nextDist});
                    }
                }
            }
        }
        int ans=-1;
        for (int i=1;i<n+1;i++) ans=Math.max(ans,distances[i]);
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}