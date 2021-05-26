package tree;

import java.util.*;

public class NaryMaxDepth {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    private int maxDepth = 0;

    public int maxDepth(Node root) {
        helper(root, 0);
        return maxDepth;
    }

    public void helper(Node root, int currentDepth) {
        if (root.children == null) {
            maxDepth = Math.max(currentDepth, maxDepth);
            return;
        }
        if (!root.children.isEmpty()) {
            root.children.forEach(n -> helper(n, currentDepth + 1));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1, List.of(new Node(0)));
        new NaryMaxDepth().maxDepth(root);
    }
}