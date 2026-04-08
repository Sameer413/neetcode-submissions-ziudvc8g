class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] second = strs[strs.length - 1].toCharArray();

        for(int i = 0; i < first.length; i++) {
            if((i <= second.length - 1) && (first[i] == second[i])) {
                result.append(first[i]);
            }else{
                break;
            }
        }

        return result.toString();
    }
}