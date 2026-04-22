class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones){
            maxHeap.offer(num);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int sec = maxHeap.poll();

            if(first != sec){
                maxHeap.offer(first - sec);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
