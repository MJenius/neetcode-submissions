class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        for (int i=0;i<numCourses;i++) map.put(i,new ArrayList<>());
        for (int[] prereq:prerequisites) map.get(prereq[0]).add(prereq[1]);
        for (int i=0;i<numCourses;i++) if (!dfs(i,map,visited)) return false;
        return true;
    }
    private boolean dfs(int course,Map<Integer,List<Integer>> map,Set<Integer> visited) {
        if (visited.contains(course)) return false;
        if (map.get(course).isEmpty()) return true;
        visited.add(course);
        for (int prereq:map.get(course)) if (!dfs(prereq,map,visited)) return false;
        visited.remove(course);
        map.put(course,new ArrayList<>());
        return true;
    }
}
