package recursion.backTracking;

import java.util.*;

public class DFSwState {

    public static String[] ternaryTreePaths(Node root) {
        // WRITE YOUR BRILLIANT CODE HERE
        if (root == null) return new String[0];
        List<String> list = new ArrayList<String>();
        for(var n:root.children){
            ternaryTreePathsHelper(n, root.val + "", list);
        }
        return list.toArray(new String[list.size()]);
    }

    public static void ternaryTreePathsHelper(Node root, String s, List<String> result) {
       
        String newStr = s +"->" + root.val;
        if (root.children[0] == null && root.children[1] == null && root.children[2] == null) {         
            result.add(newStr);
            return;
        };
       for(Node n: root.children){
        if(n != null){
            ternaryTreePathsHelper(n, newStr, result);
        }
       }
    }

    /** Driver class, do not change **/
    static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }

        public static Node buildTree(Iterator<String> nodes) {
            String nxt = nodes.next();
            if (nxt.equals("x"))
                return null;
            Node node = new Node(Integer.parseInt(nxt), new Node[3]);
            for (int i = 0; i < 3; i++) {
                node.children[i] = buildTree(nodes);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();
        String[] paths = ternaryTreePaths(root);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
