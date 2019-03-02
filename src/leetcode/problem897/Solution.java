package leetcode.problem897;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<TreeNode> list = new ArrayList<TreeNode>();
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return root;
        cenBianLi(root);
        TreeNode newRoot = null;
        TreeNode tempNode = newRoot;
        for(TreeNode v : list){
            if(newRoot==null){
                newRoot = v;
                tempNode = newRoot;
            }else{
                tempNode.left = null;
                tempNode.right = v;
                tempNode = tempNode.right;
            }
        }
        tempNode.left=null;
        tempNode.right = null;
        return newRoot;
    }
    public void cenBianLi(TreeNode root){
        if(root==null) return ;
        cenBianLi(root.left);
        list.add(root);
        cenBianLi(root.right);
    }
}
