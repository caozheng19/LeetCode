package leetcode.problem106;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] cenorder, int cenBegin, int cenEnd, int[] behindorder, int behindBegin, int behindEnd) {
        if (cenBegin > cenEnd || behindBegin > behindEnd) {
            return null;
        }
        TreeNode root = new TreeNode(behindorder[behindEnd]);
        int flag = cenBegin;

        while (flag <= cenEnd && cenorder[flag] != root.val) {  //cenorder[flag] != root.val&&flag <= cenEnd会报错越界
            // System.out.println(flag+": "+cenorder[flag]);
            flag++;
        }
        int dis = flag - cenBegin;
        root.left = buildTree(cenorder, cenBegin, flag - 1, behindorder, behindBegin, behindBegin + dis - 1);
        root.right = buildTree(cenorder, flag + 1, cenEnd, behindorder, behindBegin + dis, behindEnd - 1);
        return root;
    }
}