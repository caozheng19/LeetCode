package leetcode.problem104;

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
    public int maxDepth(TreeNode root) {
        int depthCount = 0;
        List<List<Integer>> outerList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return 0;
        queue.add(root);
        while(!queue.isEmpty()){
             List<Integer> innerList = new ArrayList<>();
             int queueSize = queue.size();
             depthCount++;
             while(queueSize>0) {
                 TreeNode treeNode = queue.poll();
                 innerList.add(treeNode.val);
                 if (treeNode.left != null) {
                     queue.add(treeNode.left);
                 }
                 if (treeNode.right != null) {
                     queue.add(treeNode.right);
                 }
                 queueSize--;
             }
             outerList.add(innerList);
        }
        return depthCount;
    }
}
