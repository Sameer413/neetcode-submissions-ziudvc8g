class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        rotateHelper(nums, 0, nums.length - 1);
        rotateHelper(nums, 0, k - 1);
        rotateHelper(nums, k, nums.length - 1);

    }

    private void rotateHelper(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}