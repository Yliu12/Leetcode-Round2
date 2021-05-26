package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import recursion.TreeNode;
// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
public class Serdes {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if(n == null){
                sb.append("null").append(",");
            } else{
                sb.append(n.val).append(",");
                queue.offer(n.left);
                queue.offer(n.right);
            }


        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

        
    public boolean isSorted(LinkedList<TreeNode> list,TreeNode prev) {
        return false;
        
        // list.getFirst()
       
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        data = data.replace("[", "").replace("]", "");

        Queue<String> nodeValQueue = new LinkedList<String>(Arrays.asList(data.split(",")));
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        TreeNode root = nodeFactory(nodeValQueue.poll());
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode head = nodeQueue.poll();
            head.left = nodeFactory(nodeValQueue.poll());
            head.right = nodeFactory(nodeValQueue.poll());

            if (head.left != null)
                nodeQueue.offer(head.left);
            if (head.right != null)
                nodeQueue.offer(head.right);

        }
        return root;

    }

    public static TreeNode nodeFactory(String val) {
        System.out.println(val);

        if ( null == val || "null".equals(val))
            return null;
        else
            return new TreeNode(Integer.parseInt(val));

    }

    public static void main(String[] args) {
        var root = deserialize("[1,2,3,null,null,4,5]");
        deserialize(serialize(root));
    }
}