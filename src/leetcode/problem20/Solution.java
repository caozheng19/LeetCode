package leetcode.problem20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : sArray){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(isCp(stack.peek(),c)){
                    stack.pop();
                }else{
                    stack.add(c);
                }
            }
        }
        return stack.size()==0?true:false;
    }

    public boolean isCp(char c1,char c2){
        if((c1=='('&&c2==')')||(c1=='{'&&c2=='}')||(c1=='['&&c2==']')){
            return true;
        }
        return false;
    }
}