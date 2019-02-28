package leetcode.problem993;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        if(root.left==null||root.right==null) return false;
        Map<TreeNode,TreeNode> map  = new HashMap<>();
        Map<TreeNode,Integer> brotherMap = new HashMap<>();
        Queue<Map<TreeNode,TreeNode>> queue = new LinkedList<>();
        map.put(root,root);
        queue.add(map);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize>0){
                Map<TreeNode,TreeNode> map1 = queue.poll();
                for(TreeNode t : map1.keySet()){
                    if(t.val==x){
                        brotherMap.put(map1.get(t),x);
                    }
                    if(t.val==y){
                        brotherMap.put(map1.get(t),y);
                    }
                    if(t.left!=null){
                        Map<TreeNode,TreeNode> map2 = new HashMap();
                        //第一个参数是当前节点 第二个参数是父节点
                        map2.put(t.left,t);
                        queue.add(map2);
                    }
                    if(t.right!=null){
                        Map<TreeNode,TreeNode> map2 = new HashMap();
                        map2.put(t.right,t);
                        queue.add(map2);
                    }
                }
                queueSize--;

            }
            if(brotherMap.size()==2) return true;
            else brotherMap.clear();
        }
        return false;
    }
}
