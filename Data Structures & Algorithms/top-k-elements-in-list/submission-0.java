class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int key : freq.keySet()) {
            int frequency = freq.get(key);

            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i = bucket.length - 1; i >= 0 && counter < k; i--){
            if(bucket[i] != null) {
                for(Integer num : bucket[i]){
                    res[counter++] = num;
                }
            }
        }
        return res;
    }
}
