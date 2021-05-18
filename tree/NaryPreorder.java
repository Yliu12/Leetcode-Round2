import java.util.*;

public class NaryPreorder {

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

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            Node curr = list.poll();
            result.add(curr.val);
            if (curr.children != null && !curr.children.isEmpty()) {
                Collections.reverse(curr.children);
                curr.children.stream().forEach(n -> list.offer(n));
            }
        }

        return result;
    }

    public List<Integer> preorderRecursion(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        helper(root, result);

        return result;
    }

    public void helper(Node node, List<Integer> result) {
        if(node == null) return;    
        result.add(node.val);
        if (node.children != null && !node.children.isEmpty()) {
            node.children.forEach(n-> helper(n, result));
        }
    }

}
