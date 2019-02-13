package leetcode.problem112;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null) return false;
        stack.push(root);
        if(root.val==sum&&root.right==null&&root.left==null) return true;
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode.right!=null){
                treeNode.right.val +=treeNode.val;
                if(treeNode.right.val==sum&&treeNode.right.left==null&&treeNode.right.right==null) return true;
                stack.push(treeNode.right);
            }
            if(treeNode.left!=null){
                treeNode.left.val +=treeNode.val;
                if(treeNode.left.val==sum&&treeNode.left.left==null&&treeNode.left.right==null) return true;
                stack.push(treeNode.left);
            }
        }
        return false;
    }
}
