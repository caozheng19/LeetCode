package leetcode.problem543;



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private  int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        countDepth(root);
        return res;
    }
    public int  countDepth(TreeNode root){
        if(root==null) return 0;
        int left = root.left==null?0:1+countDepth(root.left);
        int right = root.right==null?0:1+countDepth(root.right);
        res =  Math.max(res,left+right);
        return Math.max(left,right);
    }
}
