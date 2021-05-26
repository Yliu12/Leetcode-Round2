package tree;

import java.util.LinkedList;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree -- leetcode
public class LowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
        LinkedList<Node> n1Path = new LinkedList<Node>();
        dfs(root, v1, n1Path);
        LinkedList<Node> n2Path = new LinkedList<Node>();
        dfs(root, v2, n2Path);
        Node n1Parent = n1Path.poll();
        Node n2Parent = n2Path.poll();
        Node n1LastEqual = null;
        while (n1Parent == n2Parent) {
            n1LastEqual = n1Parent;
            n1Parent = n1Path.poll();
            n2Parent = n2Path.poll();
        }
        return n1LastEqual;
    }

    public static void dfs(Node head, int data, LinkedList<Node> path) {
        if (head.data == data) {
            // System.out.println("found "+ head.data);
            path.push(head);
            return;
        }
        if (head.left != null) {
            dfs(head.left, data, path);

        }
        if (head.right != null) {
            dfs(head.right, data, path);
        }

        if ((head.left != null && head.left == path.peek()) || (head.right != null && head.right == path.peek())) {
            // System.out.println("adding "+ head.data);
            path.push(head);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(-1);
        root.right = new Node(1);

        root.left.left = new Node(-2);
        root.left.left.left = new Node(-3);
        root.right.right = new Node(2);
        System.out.println(lca(root, -3, 2).data);
    }

}