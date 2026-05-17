class Solution {
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int n = s.length();

        for (int freq : count) {
            if (freq > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new Pair((char) (i + 'a'), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            Pair first = pq.poll();
            Pair second = pq.poll();

            sb.append(first.ch);
            sb.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) {
                pq.offer(first);
            }

            if (second.freq > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll().ch);
        }

        return sb.toString();
    }
}