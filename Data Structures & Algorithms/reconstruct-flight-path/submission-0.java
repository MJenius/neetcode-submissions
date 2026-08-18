class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        for (List<String> ticket:tickets) {
            String from=ticket.get(0);
            String to=ticket.get(1);
            graph.computeIfAbsent(from,k->new ArrayList<>()).add(to);
        }
        for (List<String> dest:graph.values()) Collections.sort(dest);
        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK",ans,graph);
        return ans;
    }
    private void dfs(String airport,LinkedList<String> ans,Map<String,List<String>> graph) {
        List<String> dests=graph.get(airport);
        while (dests!=null && !dests.isEmpty()) {
            String next=dests.remove(0);
            dfs(next,ans,graph);
        }
        ans.addFirst(airport);
    }
}
