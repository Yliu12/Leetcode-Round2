package recursion;

import java.util.*;
import java.util.Scanner;
import java.util.function.Function;

class DFSTree {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Max Depth devide and conquer
    public static int treeMaxDepth(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        if (root == null)
            return 0;
        return Math.max(treeMaxDepth(root.right), treeMaxDepth(root.left)) + 1;
    }

    // In a binary tree, a node is considered "visible" if no node on the
    // root-to-itself path has a greater value. The root is always "visible" since
    // there are no other nodes between the root and itself. Given a binary tree,
    // count the number of "visible" nodes.
    public static int visibleTreeNode(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        return visibleTreeNodeHelper(root, Integer.MIN_VALUE);
    }

    public static int visibleTreeNodeHelper(Node<Integer> root, int previousMax) {
        if (root == null)
            return 0;
        int add = 0;
        if (root.val > previousMax) {
            previousMax = root.val;
            add = 1;
        }
        return visibleTreeNodeHelper(root.left, previousMax) + visibleTreeNodeHelper(root.right, previousMax) + add;
    }


    public static boolean validBst(Node<Integer> root) {
        return validBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean validBstHelper(Node<Integer> root, int min, int max) {
        if (root == null)
            return true;
        if(root.val>=max || root.val<=min){
            return false;
        }
        return validBstHelper(root.left, min, root.val) && validBstHelper(root.right, root.val, max);
    }

   // Lowest Common Ancestor of a Binary Tree
   static Node lca = null;
    public static Node lca(Node root, Node node1, Node node2) {
        // WRITE YOUR BRILLIANT CODE HERE
        boolean rootFlag = lcaHelper(root, node1, node2);
        if(lca == null && rootFlag)lca = root;
        return lca;
    }

    public static boolean lcaHelper(Node root, Node node1, Node node2){
        if(root == null) return false;
        if(root == node1 || root == node2){
            return true;
        }
        boolean left =  lcaHelper(root.left, node1, node2);
        boolean right =  lcaHelper(root.right, node1, node2);
        if(left && right){
            lca = root; 
        }
        return left || right;
    }

    public static Node lcaNoHelper(Node root, Node node1, Node node2) {
        if(root == null) return null;
        if(root == node1 || root == node2) return root;
        Node l = lcaNoHelper(root.left, node1, node2);
        Node r = lcaNoHelper(root.right, node1, node2);
        if(l == null && r == null) return null;
        if(l!= null && r!= null){
            return root;
        }
        return l == null? r : l;
    }






    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x"))
            return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        validBst(root);
    }
}
