package leetcode.problem105;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        System.out.println(preorder.length);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preBegin, int preEnd, int[] cenorder, int cenBegin, int cenEnd) {
        if (preBegin > preEnd || cenBegin > cenEnd) return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        int flag = cenBegin;
        while (cenorder[flag] != root.val && flag <= cenEnd) {
            flag++;
        }
        int dis = flag - cenBegin;  //左子树的长度
        root.left = build(preorder, preBegin + 1, preBegin + dis, cenorder, cenBegin, flag - 1);
        root.right = build(preorder, preBegin + dis + 1, preEnd, cenorder, flag + 1, cenEnd);
        return root;

    }
}
