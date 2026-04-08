class Solution {
    public String minWindow(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for(char ch : t.toCharArray()) tMap[ch]++;

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart= 0;


        while(right < s.length()){
            sMap[s.charAt(right)]++;

            while(contains(sMap, tMap)){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    minStart = left;
                }

                sMap[s.charAt(left++)]--;
            }

            right ++;
        }

        return minLength == Integer.MAX_VALUE ? "": s.substring(minStart, minStart + minLength);
    }

    private boolean contains(int[] sMap, int[] tMap){
        for(int i = 0; i < 256; i++){
            if(tMap[i] > sMap[i]) {
                return false;
            }
        }

        return true;
    }
}
