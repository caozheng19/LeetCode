package leetcode.problem108;



class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null) return null;
        TreeNode root = buildTree(nums,0,nums.length-1);
        return root;
    }
    public TreeNode buildTree(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        if(left==right){
            TreeNode node = null;
            return  node = new TreeNode(nums[left]);
        }
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums,left,mid-1);
        node.right = buildTree(nums,mid+1,right);
        return node;
    }
}