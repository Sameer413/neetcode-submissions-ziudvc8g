class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String freqStr = getFrequencyStr(str);

            if(!map.containsKey(freqStr)){
                map.put(freqStr, new ArrayList<>());
            }

            map.get(freqStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String getFrequencyStr(String str) {
        int[] freq = new int[26];

        for(char c: str.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder freqStr = new StringBuilder("");
        char c = 'a';

        for(int i: freq){
            freqStr.append(c);
            freqStr.append(i);
            c++;
        }

        return freqStr.toString();
    }
}
