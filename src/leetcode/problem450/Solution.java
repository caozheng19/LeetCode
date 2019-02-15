package leetcode.problem450;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (!containKey(root, key)) {
            return null;
        } else {
            if (root.val == key) {
                if (root.left == null && root.right != null) {
                    return root.right;
                } else if (root.right == null && root.left != null) {
                    return root.left;
                } else if (root.left==null&&root.right==null) {
                    return null;
                } else if (root.left!=null&&root.right!=null) {
                    findMinNode(root.right);
                }
            }
        }
        return null;
    }
    /*
      判断二叉树中是否存在该节点
    */
    public boolean containKey(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        return containKey(root.left, key);
       // return containKey(root.right, key);
    }

    public TreeNode findMinNode(TreeNode node){
        if(node==null) return null;
        if(node.left==null&&node.right==null) return node;
        findMinNode(node.left);
        return null;
    }

}