class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int first = 0, second = 0;

        while(first != word1.length() && second != word2.length()){
            sb.append(word1.charAt(first)).append(word2.charAt(second));
            first++;
            second++;
        }

        while(first != word1.length()){
            sb.append(word1.charAt(first));
            first++;
        }
        
        while(second != word2.length()){
            sb.append(word2.charAt(second));
            second++;
        }

        return sb.toString();
    }
}