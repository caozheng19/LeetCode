package leetcode.problem872;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<Integer> root1List  = new ArrayList<Integer>();
    public List<Integer> root2List  = new ArrayList<Integer>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        bianliroot1(root1);
        bianliroot2(root2);
        if(root1List.size()!=root2List.size()) return false;
        for(int i = 0;i<root1List.size();i++){
            if(root1List.get(i)!=root2List.get(i)) return false;
        }
        return true;
    }
    public void bianliroot1(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            root1List.add(root.val);
        }
        bianliroot1(root.left);
        bianliroot1(root.right);

    }
    public void bianliroot2(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            root2List.add(root.val);
        }
        bianliroot2(root.left);
        bianliroot2(root.right);
    }
}