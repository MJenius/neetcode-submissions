class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs=new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src]=0;
        for (int i=0;i<=k;i++) {
            int[] temp=costs.clone();
            for (int[] flight:flights) {
                int source=flight[0];
                int destination=flight[1];
                int cost=flight[2];
                if (costs[source]==Integer.MAX_VALUE) continue;
                if (temp[destination]>costs[source]+cost) temp[destination]=costs[source]+cost;
            }
            costs=temp;
        }
        return costs[dst]==Integer.MAX_VALUE ? -1:costs[dst];
    }
}
