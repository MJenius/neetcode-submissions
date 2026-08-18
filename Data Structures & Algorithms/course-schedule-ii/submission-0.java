class Solution {
    private List<Integer> output=new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        for (int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        indegree=new int[numCourses];
        for (int[] pre:prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0) dfs(i);
        }
        if (output.size()!=numCourses) return new int[0];
        int[] ans=new int[output.size()];
        for (int i=0;i<output.size();i++) ans[i]=output.get(i);
        return ans;
    }
    private void dfs(int node) {
        output.add(node);
        indegree[node]--;
        for (int neighbour:adj.get(node)) {
            indegree[neighbour]--;
            if (indegree[neighbour]==0) dfs(neighbour);
        }
    }
}
