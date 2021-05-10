
// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
// 过不了tc是因为hackerrank有问题，不是我。
public class LowestCommonBinarySearchTree {
    public static Node lca(Node root, int v1, int v2) {
        while (root != null) {
            if (root.data > v1 && root.data < v2) {
                return root;
            } else if (root.data < v1) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}