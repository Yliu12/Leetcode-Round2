package recursion;

import java.util.*;

public class TreeSerDes {
    public static String serialize(Node root) {
        var sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public static void serializeHelper(Node n, StringBuilder sb) {
        if (n == null) {
            sb.append("x ");
            return;
        }
        sb.append(n.val + " ");
        serializeHelper(n.left, sb);
        serializeHelper(n.right, sb);
    }

    public static int deserializeHelper(Node root, String[] arr, int index) {
        if (index > arr.length) {
            return -1;
        }
        if (!"x".equals(arr[index])) {
            Node left = new Node(Integer.parseInt(arr[index]));
            root.left = left;
            index = deserializeHelper(left, arr, index + 1);
        } else {
            index++;
        }
        if (!"x".equals(arr[index])) {
            Node right = new Node(Integer.parseInt(arr[index]));
            root.right = right;
            index = deserializeHelper(right, arr, index + 1);
        } else {
            return index + 1;
        }
        return index;
    }

    public static Node deserialize(String s) {
        var chars = s.split(" ");
        if(chars.length == 0 || (chars[0]).equals("x") ) return null;
        var root = new Node(Integer.parseInt(chars[0]));
        if(chars.length == 1) return root;
        deserializeHelper(root, chars, 1);
        return root;
    }

    /** Driver class, do not change **/
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public static Node buildTree(Iterator<String> iter) {
            String nxt = iter.next();
            if (nxt.equals("x"))
                return null;
            Node node = new Node(Integer.parseInt(nxt));
            node.left = buildTree(iter);
            node.right = buildTree(iter);
            return node;
        }

        public static void printTree(Node root, List<String> out) {
            if (root == null) {
                out.add("x");
            } else {
                out.add(String.valueOf(root.val));
                printTree(root.left, out);
                printTree(root.right, out);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();
        Node newRoot = deserialize(serialize(root));
        ArrayList<String> out = new ArrayList<>();
        Node.printTree(newRoot, out);
        System.out.println(String.join(" ", out));
    }
}
