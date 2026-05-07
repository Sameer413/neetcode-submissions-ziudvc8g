class Node {
    Node[] children;
    String word;

    public Node() {
        children = new Node[26];
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, Node node, List<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];

        if (node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Word found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();

        for (String word : words) {
            Node node = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        return root;
    }
}
