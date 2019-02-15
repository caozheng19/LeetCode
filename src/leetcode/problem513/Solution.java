package leetcode.problem513;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            list.clear();
            int stackSize = stack.size();
            System.out.println("--------");
            while(stackSize>0){
                TreeNode node = stack.pop();
                list.add(node.val);
                System.out.print(node.val);
                if(node.right!=null){
                    stack.add(node.right);
                }
                if(node.left!=null){
                    stack.add(node.left);
                }
                stackSize--;
            }
        }
        return list.get(0);
    }
}