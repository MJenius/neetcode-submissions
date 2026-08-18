class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int gift:gifts) minheap.offer(-gift);
        for (int i=0;i<k;i++) {
            int max=Math.abs(minheap.poll());
            minheap.offer(-(int)Math.sqrt(max));
        }
        long ans=0;
        while (minheap.size()>0) {
            ans+=Math.abs(minheap.poll());
        }
        return ans;
    }
}