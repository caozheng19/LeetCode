package leetcode.problem230;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private List<Integer> list = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        cenTravelse(root);
        Integer result = list.get(k-1);
        int resultInt = result.intValue();
        return resultInt;
    }
    public void cenTravelse(TreeNode node){
        if(node ==null) return;

        if(node.left!=null){
            cenTravelse(node.left);
        }

        list.add(node.val);
        if(node.right!=null){
            cenTravelse(node.right);
        }
    }
}