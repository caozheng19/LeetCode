package leetcode.problem242;

import java.util.Arrays;

class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()){
                return false;
            }
            int flag =1;
            String[] arrayS = s.split("");
            String[] arrayT = t.split("");
            Arrays.sort(arrayS);
            Arrays.sort(arrayT);
            for(int i = 0;i<s.length();i++){
                if(!arrayS[i].equals(arrayT[i])){
                    flag = 0;
                    System.out.println(arrayS[i]+"   "+arrayS[i]);
                }
            }
            if(flag==1) return true;
            return false;
        }
}

