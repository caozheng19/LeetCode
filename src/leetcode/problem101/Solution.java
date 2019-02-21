package leetcode.problem101;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
       TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if(root.left==null) return false;
        if(root.right==null) return false;
        return judge(root.left,root.right);

    }
    public boolean judge(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null) return false;
        if(node2==null) return false;
        if(node1.val==node2.val){
            return judge(node1.left,node2.right)&&judge(node1.right,node2.left);
        }else{
            return false;
        }
    }
}