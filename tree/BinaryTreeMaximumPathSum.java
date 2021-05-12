
// https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int curMax = pathSum(root, maxSum);
        return maxSum > curMax ? maxSum : curMax;
    }

    public int pathSum(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int right = pathSum(root.right, max);
        right = right > 0 ? right : 0;
        int left = pathSum(root.left, max);
        left = left > 0 ? left : 0;

        int curNodeMax = left + right + root.val;
        maxSum = Math.max(curNodeMax, maxSum);
        return Math.max(right, left) + root.val;
    }
}
