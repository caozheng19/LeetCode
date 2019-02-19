package leetcode.problem350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//思路就是把数组的值作为键 把数组中值的个数作为值
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num:nums1){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        for(int num:nums2){
            if(map.containsKey(num)){
                System.out.println(num);
                if(map.get(num)>1){
                    map.put(num,map.get(num)-1);
                    list.add(num);
                }else{
                    map.remove(num);
                    list.add(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
