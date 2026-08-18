class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freqmap=new HashMap<>();
        for (char task:tasks) freqmap.put(task,freqmap.getOrDefault(task,0)+1);
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqmap.values());
        int time=0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp=new ArrayList<>();
            for (int i=0;i<n+1;i++) if(!maxHeap.isEmpty()) temp.add(maxHeap.poll());
            for (int freq:temp) {
                if (--freq>0) maxHeap.offer(freq);
            }
            time+=maxHeap.isEmpty() ? temp.size():n+1;
        }
        return time;
    }
}
