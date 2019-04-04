package leetcode.problem70;

public class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second =2;
        int third = 0;
        for(int i = 3;i<=n;i++){
            third = first+second;
            first = second;
            second = third;
        }
        if(n==1) return first;
        else if(n==2) return second;
        else return third;
    }
}
