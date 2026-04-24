class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempSet, int[] nums, int start){
        res.add(new ArrayList<>(tempSet));

        for(int i = start; i < nums.length; i++){
            tempSet.add(nums[i]);

            backtrack(res, tempSet, nums, i+1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}
