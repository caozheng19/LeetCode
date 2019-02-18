package leetcode.problem349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int v:nums1){
            list.add(v);
        }
        for(int v:nums2){
            if(list.contains(v)){
                map.put(v,v);
            }
        }
        int index = 0;
        int[] result = new int[map.size()];
        for(Integer v : map.values()){
            int vToInt = v.intValue();
            result[index++]=vToInt;
        }
        return result;
    }
}