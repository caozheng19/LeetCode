package leetcode.problem110;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(countHeight(root.left) - countHeight(root.right)) > 1){
            return false;
        }
        if(isBalanced(root.left)&&isBalanced(root.right)){
            return true;
        }
        return false;
    }
    public int countHeight(TreeNode node){
        if(node==null){
            return 0;
        }else{
            int leftHeight = 1+countHeight(node.left);
            int rightHeight = 1+countHeight(node.right);
            return leftHeight>=rightHeight?leftHeight:rightHeight;
        }
    }
}
