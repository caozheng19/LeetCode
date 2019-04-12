package leetcode.problem496;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums2.length;i++){
            int cur = nums2[i];
            while(!stack.isEmpty()&&stack.peek()<cur){
                map.put(stack.pop(),cur);
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        int [] res = new int[nums1.length];
        int idx = 0;
        for(int num : nums1){
            res[idx++] = map.get(num);
        }
        return res;
    }
}
