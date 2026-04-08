class Solution {
    public boolean isAnagram(String s, String t) {
  if (s.length() != t.length()) return false;

        int[] count = new int[26]; // Since input contains lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;  // Increment for character in 's'
            count[t.charAt(i) - 'a']--;  // Decrement for character in 't'
        }

        for (int num : count) {
            if (num != 0) return false; // If any count is nonzero, it's not an anagram
        }

        return true;
    }
}
