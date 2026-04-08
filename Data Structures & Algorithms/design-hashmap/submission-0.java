class MyHashMap {
    private static final int SIZE = 1000;
        private LinkedList<Node>[] buckets;
    private static class Node {
            int key, value;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    public MyHashMap() {
                    buckets = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }
        

        
    }
    private int hash(int key) {
            return key % SIZE;
        }
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value; 
                return;
            }
        }

        bucket.add(new Node(key, value));
    }
    
    public int get(int key) {
         int index = hash(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = buckets[index];

        bucket.removeIf(node -> node.key == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */