package leetcode.problem102;

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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List outerList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        System.out.println(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List innerList = new ArrayList<>();
            while (queueSize > 0) {
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
        return outerList;
    }
}