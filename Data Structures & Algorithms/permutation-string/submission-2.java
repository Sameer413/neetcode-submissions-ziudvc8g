class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>(); 
        Map<Character, Integer> window = new HashMap<>(); 

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int k = s1.length();

        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(i >= k){
                char left = s2.charAt(i-k);
                if(window.get(left) == 1){
                    window.remove(left);
                }else{
                    window.put(left, window.get(left) - 1);
                }
            }

            if(window.equals(map)){
                return true;
            }
        }

        return false;
    }
}
