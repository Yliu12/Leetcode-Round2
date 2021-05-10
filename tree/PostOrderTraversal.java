// https://www.hackerrank.com/challenges/tree-postorder-traversal/problem

public class PostOrderTraversal {
    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf(root.data + " ");
    }
}