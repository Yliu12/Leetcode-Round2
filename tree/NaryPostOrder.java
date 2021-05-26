package tree;

import java.util.*;

public class NaryPostOrder {

    // Definition for a Node.
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

    public List<Integer> postOrder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                node.children.forEach(n -> stack.push(n));
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postOrderRecursion(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        helper(root, result);

        return result;
    }

    public void helper(Node node, List<Integer> result) {
        if (node == null)
            return;

        if (node.children != null && !node.children.isEmpty()) {
            node.children.forEach(n -> helper(n, result));
        }
        result.add(node.val);
    }

}
