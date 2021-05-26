package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfABinaryTree {

    public static int height(Node root) {
        // Write your code here.
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node current = queue.poll();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            depth++;
        }
        return depth - 1;
    }
                                                        
    public static int maxDepth = 0;

    public static int heightRecursion(Node root) {
        if (root == null)
            return 0;
        getHeight(root, 0);
        return maxDepth;
    }

    public static void getHeight(Node root, int depth) {
        if(root == null){
            return;
        }
        getHeight(root.left, depth+1);
        getHeight( root.right, depth+1);
        maxDepth = Math.max(depth, maxDepth);
    }
}
