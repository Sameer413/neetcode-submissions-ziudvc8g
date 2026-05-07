class Node{
    Node[] children;
    boolean isEnd;

    public Node(){
        children = new Node[26];
        isEnd = false;
    }
}


class PrefixTree {
    private Node root;

    public PrefixTree() {
        root = new Node();     
    }

    private int getIdx(char ch){
        return ch - 'a';
    }

    public void insert(String word) {
        Node current = root;

        for(char ch: word.toCharArray()){
            int idx = getIdx(ch);

            if(current.children[idx] == null){
                current.children[idx] = new Node();
            }

            current = current.children[idx];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = root;

        for(char ch: word.toCharArray()){
            int idx = getIdx(ch);

            if(current.children[idx] == null){
                return false;
            }

            current = current.children[idx];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = root;

        for(char ch: prefix.toCharArray()){
            int idx = getIdx(ch);

            if(current.children[idx] == null){
                return false;
            }

            current = current.children[idx];
        }

        return true;
    }
}
