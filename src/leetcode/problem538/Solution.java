package leetcode.problem538;


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        reBuildTree(root);
        return root;
    }
    public void reBuildTree(TreeNode root){
        if(root==null) return;
        reBuildTree(root.right);
        root.val+=pre;
        pre = root.val;
        reBuildTree(root.left);
    }
}