package leetcode.problem226;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queueSize--;
            }
        }
        return root;

    }
}
