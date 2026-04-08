class Solution {
    public boolean isPalindrome(String s) {
        String regexString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = regexString.length() - 1;

        while (start < end){
            if (regexString.charAt(start) != regexString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
