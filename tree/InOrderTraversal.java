package tree;

// https://www.hackerrank.com/challenges/tree-inorder-traversal/problem

public class InOrderTraversal {
    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.printf(root.data + " ");
        inOrder(root.right);
    }

}
