class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size()>maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek():(maxHeap.peek()+minHeap.peek())*0.5;
    }
}
