package leetcode.problem98;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public int flag = 1;
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = buildList(root);
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)) return false;
        }
        return true;
    }
    public List<Integer> buildList(TreeNode root){
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        list.addAll(buildList(root.left));
        list.add(root.val);
        list.addAll(buildList(root.right));

        return list;
    }
}