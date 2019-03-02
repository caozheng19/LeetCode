package leetcode.problem700;




class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        bianli(root,val);
        return res;
    }
    public void bianli(TreeNode root,int val){
        if(root==null) return;
        if(root.val==val) res = root;
        bianli(root.left,val);
        bianli(root.right,val);
    }
}