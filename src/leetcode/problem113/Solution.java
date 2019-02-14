package leetcode.problem113;

import java.util.ArrayList;
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
    private static List<List<Integer>> outerList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        outerList.clear();  //如果不加这一句outerList中会保存上一次测试示例的数据 因为static变量只加载一次 如果想不用clear 可以向下面注释代码那样写
        List<Integer> innerList = new ArrayList<>();
        if(root==null) {
            return outerList;
        }
        dfs(root,0,innerList,sum);
        return outerList;
    }

    public void dfs(TreeNode root,int pathSum,List<Integer> innerList,int sum){
        innerList.add(root.val);
        pathSum+=root.val;
        if(root.left==null&&root.right==null&&pathSum==sum){
            outerList.add(new ArrayList<>(innerList));    //这里换成outerList.add(innerList)会报错
        }
        if(root.left!=null){
            dfs(root.left,pathSum,innerList,sum);
        }
        if(root.right!=null){
            dfs(root.right,pathSum,innerList,sum);
        }
        innerList.remove(innerList.size()-1);
    }
}
//class Solution {
//    // private static List<List<Integer>> outerList = new ArrayList<>();
//    private List<List<Integer>> outerList = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        //outerList.clear();  //如果不加这一句outerList中会保存上一次测试示例的数据
//        List<Integer> innerList = new ArrayList<>();
//        if(root==null) {
//            return outerList;
//        }
//        dfs(root,0,innerList,sum);
//        return outerList;
//    }
//
//    public void dfs(TreeNode root,int pathSum,List<Integer> innerList,int sum){
//        innerList.add(root.val);
//        pathSum+=root.val;
//        if(root.left==null&&root.right==null&&pathSum==sum){
//            outerList.add(new ArrayList<>(innerList));    //这里换成outerList.add(innerList)会报错
//        }
//        if(root.left!=null){
//            dfs(root.left,pathSum,innerList,sum);
//        }
//        if(root.right!=null){
//            dfs(root.right,pathSum,innerList,sum);
//        }
//        innerList.remove(innerList.size()-1);
//    }