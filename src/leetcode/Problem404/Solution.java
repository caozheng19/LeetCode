package leetcode.Problem404;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int sum = 0;
        sum = countSum(root,sum);
        return sum;
    }
    public int countSum(TreeNode root,int sum){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    if(node.left.left==null&&node.left.right==null)
                        sum+=node.left.val;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queueSize--;
            }
        }
        return sum;
    }
}