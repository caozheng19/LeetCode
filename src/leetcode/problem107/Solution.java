package leetcode.problem107;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> outerList = new ArrayList<>();

        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queueSize--;
            }
            stack.add(innerList);
        }
        while(!stack.isEmpty()){
            outerList.add(stack.pop());
        }
        return outerList;
    }
}
