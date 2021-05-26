package recursion;

// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
// 递归小天才
public class PathSum {
    public int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        this.targetSum = targetSum;
        return pathSum(root, 0);
    }

    public boolean pathSum(TreeNode root, int sum) {
        int currentSum = sum + root.val;
        if (root.left == null && root.right == null)
            return currentSum == targetSum;

        return (root.left == null ? false : pathSum(root.left, currentSum))
                || (root.right == null ? false : pathSum(root.right, currentSum));
    }
}
