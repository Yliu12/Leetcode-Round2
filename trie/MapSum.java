import java.util.HashMap;
import java.util.Set;

public class MapSum {

    TrieNode root;
    HashMap<String, Integer> seen = new HashMap<>();
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        int previous = seen.getOrDefault(key, 0);
        
        TrieNode head = this.root;
        for (char c : key.toCharArray()) {
            head = head.addChildIfNotExist(c, val - previous);
        }
        head.sum += val - previous;
        seen.put(key, val);
    }

    public int sum(String prefix) {
        TrieNode head = this.root;
        for (char c : prefix.toCharArray()) {
            head = head.getChild(c);
            if (head == null) {
                return 0;
            }
        }
        return  head.sum;
    }

    public class TrieNode {
        private HashMap<Character, TrieNode> children;
        int sum = 0;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode addChildIfNotExist(char c, int val) {
            this.children.putIfAbsent(c, new TrieNode());
            this.sum += val;
            return this.children.get(c);
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public Set<Character> getChildKeys() {
            return children.keySet();
        }

        public boolean isEnd() {
            return children.isEmpty();
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);

        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
