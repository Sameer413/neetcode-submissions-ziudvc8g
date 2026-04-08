class Solution {
    public int majorityElement(int[] nums) {
        int element = -1;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                element = num;
                count++;
            }else if(element == num){
                count++;
            }else{
                count--;
            }
        }

        int count1 = 0;

        for(int i = 0; i< nums.length; i++){
           if(element == nums[i]){ count1++;}
        }

        if(count1 > nums.length/2) return element;

        return -1;
        
    }
    
}