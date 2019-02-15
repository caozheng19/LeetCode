package leetcode.problem513;


import java.util.*;


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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            list.clear();
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queueSize--;
            }
        }
        return list.get(0);
    }
}