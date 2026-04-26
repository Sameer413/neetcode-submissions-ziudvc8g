class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for(int num : nums){
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for(int i = start; i < nums.length; i++){
            swap(nums, i, start);
            helper(nums, start + 1, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
