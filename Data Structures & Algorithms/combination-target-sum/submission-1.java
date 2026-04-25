class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, target, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int idx, int[] nums, int target, List<List<Integer>> result, List<Integer> ds){
        if(idx == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        
        
        if(nums[idx] <= target){
            ds.add(nums[idx]);
            backtrack(idx, nums, target - nums[idx], result, ds);
            ds.remove(ds.size() - 1);
        }

        backtrack(idx + 1, nums, target, result, ds);
    }
}
