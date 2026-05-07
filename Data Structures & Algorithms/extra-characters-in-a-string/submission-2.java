class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        children = new Node[26];
        isEnd = false;
    }
}

class Solution {
    private Node root = new Node();

    public int minExtraChar(String s, String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }

        int n = s.length();

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;

            Node current = root;

            for (int j= i; j < n; j++) {
                char ch = s.charAt(j);

                if (current.children[ch - 'a'] == null) {
                    break;
                }

                current = current.children[ch - 'a'];

                if (current.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }

    private void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }

            current = current.children[idx];
        }

        current.isEnd = true;
    }
}