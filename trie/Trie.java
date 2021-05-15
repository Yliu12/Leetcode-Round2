import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode head = this.root;

        for(char c : word.toCharArray()){
            head = head.addChildIfNotExist((char)c);
        }
        head.addChildIfNotExist(TrieNode.END_CHAR);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode head = this.root;
        for(char c : word.toCharArray()){
            head = head.getChild((char)c);
            if(head == null){
                return false;
            }
        }
        return head.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode head = this.root;
        for(char c : prefix.toCharArray()){
            head = head.getChild((char)c);
            if(head == null){
                return false;
            }
        }
        return true;
  
    }

    public class TrieNode {
        private HashMap<Character, TrieNode> children;
        public static final char END_CHAR = ' ';
        public TrieNode(char v) {
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode addChildIfNotExist(char v){
             this.children.putIfAbsent(v, new TrieNode(v));
             return this.children.get(v);
        }

        public TrieNode getChild(char v){
            return children.get(v);
        }

        public boolean isEnd(){
            return children.get(END_CHAR) != null;
        }

    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}