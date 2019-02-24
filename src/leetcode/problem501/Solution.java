package leetcode.problem501;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        bianli(root,map);
        int []a = merge(map,list);
        return a;
    }
    public void bianli(TreeNode root,Map<Integer,Integer> map){
        if(root==null) return;
        bianli(root.left,map);
        if(!map.containsKey(root.val)){
            map.put(root.val,1);
        }else{

            map.put(root.val,map.get(root.val)+1);
        }
        bianli(root.right,map);
    }
    public int[] merge(Map<Integer,Integer> map,List<Integer> list){
        Map<Integer,String> map2 = new HashMap<>();
        String maxKey = "-1";
        Integer maxCount = -1;
        map2.put(maxCount,maxKey);
        for (Integer key : map.keySet()) {
            if(map.get(key)>=maxCount){
                if(map2.containsKey(map.get(key))){
                    maxKey = maxKey+key+" ";
                    maxCount =  map.get(key);
                    map2.put( map.get(key),maxKey);
                }else {
                    maxKey = key + " ";
                    maxCount = map.get(key);
                    map2.put(map.get(key), maxKey);
                }
            }
        }
        System.out.println(map2.get(maxCount));
        String[] result = map2.get(maxCount).split(" ");
        int[] re = new int[result.length];
        int i = 0;
        for(String s : result){
            int a = Integer.valueOf(s);
            re[i++] = a;
        }
        return re;
    }
}