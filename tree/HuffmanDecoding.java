package tree;

// https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

public class HuffmanDecoding {

    void decode(String s, Node root) {
        char[] chars = s.toCharArray();
        Node head = root;
        for (char c : chars) {
            head = c == '0' ? head.left : head.right;
            if (head.data!='\0') {
                System.out.print(head.data);
                head = root;
            }
        }
    }

    class Node {
        public int frequency; // the frequency of this tree
        public Character data;
        public Node left, right;

    }
}
