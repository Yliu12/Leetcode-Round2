package tree;

import java.util.LinkedList;
import java.util.Queue;

// https://www.hackerrank.com/challenges/tree-top-view/forum
// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

public class TopView {
    static int maxLeft = 0;
    static int minRight = 0;

    public static void topView(Node root) {

        if (root == null)
            return;
        int minLeft = 0;
        int maxRight = 0;
        Queue<NodePosition> queue = new LinkedList<>();
        LinkedList<Node> nodeList = new LinkedList<>();
        queue.offer(new NodePosition(root, 0));
        nodeList.offer(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                NodePosition current = queue.poll();
                if (current.node.left != null) {
                    Node node = current.node.left;
                    int left = current.position - 1;
                    if (left < minLeft) {
                        minLeft = left;
                        nodeList.addFirst(node);
                    }
                    queue.offer(new NodePosition(current.node.left, left));
                }

                if (current.node.right != null) {
                    Node node = current.node.right;
                    int right = current.position + 1;
                    if (right > maxRight) {
                        maxRight = right;
                        nodeList.addLast(node);
                    }
                    queue.offer(new NodePosition(current.node.right, current.position + 1));
                }
            }
        }

        for (Node node : nodeList) {
            System.out.print(node.data + " ");
        }

    }

    public static class NodePosition {
        Node node;
        int position;

        public NodePosition(Node node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    // public static void getVisable(Node root, int position) {
    // if (root == null) {
    // return;
    // }
    // getVisable(root.left, position -1 );
    // getVisable(root.right, position + 1);
    // if ()

    // maxLeft = Math.max(position, maxLeft);
    // minRight = Math.min(position, minRight);
    // }

    // public class NodePosition {
    // Node node;
    // int position;// 0 root, negative left, positive right.

    // public NodePosition(Node node, int position) {
    // this.node = node;
    // this.position = position;
    // }
    // }

}
