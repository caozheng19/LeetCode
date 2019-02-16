package leetcode.problem257;


import java.util.ArrayList;
import java.util.List;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private List<List<Integer>> outerList = new ArrayList<>();
    private List<Integer> innerList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {


        dfs(root,innerList);
        System.out.println(outerList.toString());
        return null;
    }
    public void dfs(TreeNode node,List<Integer> innerList){

        if(node==null) return;
        innerList.add(node.val);
        if(node.left!=null){
            dfs(node.left,innerList);
        }
        if(node.right!=null){
            dfs(node.right,innerList);
        }
        outerList.add(new ArrayList<>(innerList));
        // innerList.remove(innerList.size()-1);
    }
}