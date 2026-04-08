class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int require;

        for(int i = 0; i < nums.length; i++){
            require = target - nums[i];

            if(map.containsKey(require)){
                return new int[]{map.get(require), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}
