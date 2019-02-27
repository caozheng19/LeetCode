package leetcode.problem671;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 1;
        int min = root.val;
        int secondMin = root.val;
        int leftV = -1;
        int rightV = -1;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    if(flag==1){
                        if(node.left.val>min){
                            secondMin = node.left.val;
                            flag=0;
                        }
                    }
                    else{
                        if(node.left.val>min&&node.left.val<=secondMin){
                            secondMin = node.left.val;
                        }
                    }
                    queue.add(node.left);
                }
                if(node.right!=null){
                    if(flag==1){
                        if(node.right.val>min){
                            secondMin = node.right.val;
                            System.out.println("111");
                            flag=0;
                        }
                    }
                    else{
                        if(node.right.val>min&&node.right.val<=secondMin){
                            secondMin = node.right.val;
                        }
                    }
                    queue.add(node.right);
                }

                queueSize--;
            }
        }
        if(flag==0){
            return secondMin;
        }else{
            return -1;
        }
    }
}