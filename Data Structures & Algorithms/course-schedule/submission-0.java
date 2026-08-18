class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int[] pre:prerequisites) {
            int course=pre[0];
            int prereq=pre[1];
            if (graph.containsKey(prereq)) graph.get(prereq).add(course);
            else {
                List<Integer> dependents = new ArrayList<>();
                dependents.add(course);
                graph.put(prereq,dependents);
            }
        }
        Set<Integer> visited = new HashSet<>();
        for (int i=0;i<numCourses;i++) {
            if (!courseSchedule(i,visited,graph)) return false;
        }
        return true;
    }
    private boolean courseSchedule(int course,Set<Integer> visited, Map<Integer,List<Integer>> graph) {
        if (graph.get(course)==null) return true;
        if (visited.contains(course)) return false;
        visited.add(course);
        for (int prereq:graph.get(course)) {
            if (!courseSchedule(prereq,visited,graph)) return false;
        }
        visited.remove(course);
        graph.put(course,null);
        return true;
    }
}
