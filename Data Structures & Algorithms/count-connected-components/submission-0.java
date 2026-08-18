class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans=0;
        int[] visited=new int[n];
        List<Integer>[] adj=new ArrayList[n];
        for (int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for (int i=0;i<edges.length;i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        for (int i=0;i<n;i++) {
            if (visited[i]==0) {
                ans++;
                dfs(adj,visited,i);
            }
        }
        return ans;
    }
    private void dfs(List<Integer>[] adjList,int[] visited,int node) {
        visited[node]=1;
        for (int i=0;i<adjList[node].size();i++) {
            if (visited[adjList[node].get(i)]==0) dfs(adjList,visited,adjList[node].get(i));
        }
    }
}
