class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> equalvals;
    int max;
    public FreqStack() {
        freq=new HashMap<>();
        equalvals=new HashMap<>();
        max=0;
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val, 0)+1;
        freq.put(val,f);
        equalvals.putIfAbsent(f,new Stack<>());
        equalvals.get(f).push(val);
        max=Math.max(max,f);
    }
    
    public int pop() {
        int val=equalvals.get(max).pop();
        freq.put(val,freq.get(val)-1);
        if (equalvals.get(max).isEmpty()) max--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */