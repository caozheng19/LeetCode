package leetcode.problem3;
import java.util.HashSet;
import java.util.Set;

/*
如果是数组的话就是：数组.length属性;
如果是字符串的话就是：字符串.length()方法;
如果是集合的话就是：集合.size()方法
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLong = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while(i<len&&j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLong = Math.max(maxLong,j-i);
            }else{
                set.remove(s.charAt(i++));
            }

        }
        return maxLong;
    }
//     public int lengthOfLongestSubstring(String s) {

//         int len  = s.length();
//         int maxLong = 0;
//         for(int i = 0;i<len;i++){
//             for(int j = i+1;j<=len;j++){
//                 boolean result = judgeUnique(s,i,j);
//                 if(result) maxLong = Math.max(maxLong,j-i); 

//             }
//         }
//         return maxLong;
//     }

//     public boolean judgeUnique(String s,int i,int j){
//         Set<Character> set = new HashSet<>();
//         //注意这里是ii<j 不是ii<=j
//         for(int ii =i;ii<j;ii++ ){
//             Character c = s.charAt(ii);
//             if(set.contains(c)) return false;
//             set.add(c);
//         }
//         return true;
//     }

}