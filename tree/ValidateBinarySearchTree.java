import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/validate-binary-search-tree/solution/
public class ValidateBinarySearchTree {
    public int rootValue = 0;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.reverse()
        inOrder(root, queue);
        while (!queue.isEmpty()) {
            int prev = queue.poll().val;
            if (queue.peek() != null && prev >= queue.peek().val) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, Queue<TreeNode> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.offer(root);
        inOrder(root.right, list);
    }
}
