class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, Boolean.FALSE);
        }
        
        for(int num : nums) {
            int currentLen = 1;

            int nextNum = num +1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                currentLen++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            
            int prevNum = num -1;
            
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                currentLen++;
                map.put(nextNum, Boolean.TRUE);
                prevNum--;
            }

            longestLength = Math.max(currentLen, longestLength);
        }

        return longestLength;
    }
}
