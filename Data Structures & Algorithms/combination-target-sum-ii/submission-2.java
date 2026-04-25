class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void backtrack(
        int idx, int[] nums, int target, List<List<Integer>> result, List<Integer> ds) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        if(idx == nums.length || target < 0){
            return;
        }

        if (nums[idx] <= target) {
            ds.add(nums[idx]);
            backtrack(idx + 1, nums, target - nums[idx], result, ds);
            ds.remove(ds.size() - 1);
        }

        int next = idx + 1;
        while(next < nums.length && nums[next] == nums[idx]){
            next++;
        }

        backtrack(next, nums, target, result, ds);
    }
}
