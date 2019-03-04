package leetcode.problem563;





 class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public Integer Sum  = 0;
    public int findTilt(TreeNode root) {
        cenBL(root);
        return Sum;
    }
    public int cenBL(TreeNode root){

        if(root==null) return 0;
        int leftSum =  cenBL(root.left);
        int rightSum = cenBL(root.right);
        Sum+=Math.abs(leftSum-rightSum);
        return leftSum+rightSum+root.val;

    }
}
