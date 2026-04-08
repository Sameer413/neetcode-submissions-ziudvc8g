class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> groupMap;
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);

        groupMap.putIfAbsent(freq, new Stack<>());
        groupMap.get(freq).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = groupMap.get(maxFreq);

        int val = stack.pop(); // ✅ always assign

        // decrease frequency
        freqMap.put(val, freqMap.get(val) - 1);

        // if no more elements at this freq
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */