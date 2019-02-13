package leetcode.problem111;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int minDepth(TreeNode root) {
         int minDepth = 0;
         List<List<Integer>> outerList = new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         if(root == null) return 0;
         queue.add(root);
         while(!queue.isEmpty()){
             minDepth++;
             int queueSize = queue.size();
             List<Integer> innerList = new ArrayList<>();
             while(queueSize>0){
                 TreeNode treeNode = queue.poll();
                 innerList.add(treeNode.val);
                 if(treeNode.left!=null){
                     queue.add(treeNode.left);
                 }
                 if(treeNode.right!=null){
                     queue.add(treeNode.right);
                 }
                 if(treeNode.left==null&&treeNode.right==null){
                     return minDepth;
                 }
                 queueSize--;
             }
             outerList.add(innerList);
         }
         return minDepth;
    }
}
