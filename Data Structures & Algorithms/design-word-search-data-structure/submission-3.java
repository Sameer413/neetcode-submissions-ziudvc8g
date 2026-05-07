class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        children = new Node[26];
        isEnd = false;
    }
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    private int getIdx(char ch) {
        return ch - 'a';
    }

    public void addWord(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int idx = getIdx(ch);

            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }

            current = current.children[idx];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // Wildcard case
        if (ch == '.') {

            for (Node child : node.children) {
                if (child != null &&
                    dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        // Normal character
        int idx = ch - 'a';

        return dfs(word, index + 1, node.children[idx]);
    }

}
