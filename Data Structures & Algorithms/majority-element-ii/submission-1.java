class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums){
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int size = nums.length;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > size / 3){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}