package leetcode.problem965;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        return bianli(root,root.val);
    }
    public boolean bianli(TreeNode root,int val){

        if(root==null) return true;
        boolean left = false;
        boolean right = false;
        if(root.val==val) {
            left = bianli(root.left,val);
            right = bianli(root.right,val);
        }
        else return false;

        return left&&right;
    }
}
