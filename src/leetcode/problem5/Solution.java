package leetcode.problem5;

class Solution {
    public String longestPalindrome(String s) {
        int maxLong = 0;
        int markStart = -1;
        int markEnd = -1;
        if(s.length()==1){
            return s;
        }else if(s.length()<1){
            return "";
        }
        for(int i = 0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(judgeEqual(s,i,j)){
                    int temp = maxLong;
                    maxLong = Math.max(maxLong,j-i);
                    if(temp!=maxLong){
                        markStart = i;
                        markEnd = j;
                    }

                }
            }
        }
        return s.substring(markStart,markEnd);
    }
    public boolean judgeEqual(String s,int start,int end){
        int i = start;
        int j = end-1;
        while(i<=end&&j>=start){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
