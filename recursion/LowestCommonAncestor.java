// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/

class LowestCommonAncestor {
    public boolean foundOne = false;
    public boolean foundTwo = false;
    public TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode v1, TreeNode v2) {
        foundNode(root, v1);
        while(!(foundOne && foundTwo)){

        }
    }



    public boolean foundNode(TreeNode root, TreeNode v1, TreeNode v2) {
        if (root == v1) {
            this.foundOne = true;
        }
        if (root == v2) {
            this.foundTwo = true;
        }
        foundNode(root.left, v1, v2);
        foundNode(root.right, v1, v2);

        if(foundOne && foundTwo){
            
        }
        
    }
}