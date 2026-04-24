class Solution {
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, 0);
        return sum;
    }

    private void backtrack(int[] nums, int index, int currXor) {
        if (index == nums.length) {
            sum += currXor;
            return;
        }

        // include current element
        backtrack(nums, index + 1, currXor ^ nums[index]);

        // exclude current element
        backtrack(nums, index + 1, currXor);
    }
}