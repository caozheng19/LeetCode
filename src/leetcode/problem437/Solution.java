package leetcode.problem437;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    public static int count = 0;
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        if(root==null) return 0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node  = queue.poll();
                judge(node,sum,0);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queueSize--;
            }
        }
        return count;

    }
    public void judge(TreeNode node,int sum,int pathSum){
        if(node==null) return;
        pathSum+=node.val;
        if(pathSum==sum) count++;
        if(node.left!=null){
            judge(node.left,sum,pathSum);
        }
        if(node.right!=null){
            judge(node.right,sum,pathSum);
        }
    }
}